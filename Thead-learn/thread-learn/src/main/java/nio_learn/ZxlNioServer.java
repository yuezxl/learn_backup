package nio_learn;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

public class ZxlNioServer {
	
	public static Selector selector;
	
	public static ExecutorService getExecutorService() {
		return Executors.newFixedThreadPool(50);
	}
	
	public static void main(String[] args) throws IOException {
		// 先打开通道
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.socket().bind(new InetSocketAddress(8000));
		serverSocketChannel.configureBlocking(false);
		
		// 打开选择器
		selector = Selector.open();
		
		// 注册通道到选择器，让选择器能够监听到这个通道的数据
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		
		System.out.println("服务器启动成功！");
		// 不停的通过选择器轮询通道中是否有数据
		while(true) {
			if(selector.select(1000) == 0) {
				continue;
			}
			
			Set<SelectionKey> selectionKeys = selector.selectedKeys();
			// 变量set集合
			Iterator<SelectionKey> iterator = selectionKeys.iterator();
			
			while(iterator.hasNext()) {
				SelectionKey selectionKey = iterator.next();
				iterator.remove(); // 可以在此处移除，也可以在整个循环结束之后清除整个迭代器
				if(selectionKey.isAcceptable()) {
					SocketChannel socketChannel = ((ServerSocketChannel) selectionKey.channel()).accept();
					System.out.println("建立一个新的连接");
					selectionKey.interestOps(SelectionKey.OP_ACCEPT); // 取消读监听
					socketChannel.configureBlocking(false); 
					socketChannel.register(selector, SelectionKey.OP_READ); // 打开读的监听
				}
				
				if(selectionKey.isReadable()) {
					SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
					selectionKey.interestOps(SelectionKey.OP_READ);
					// 将连接交个线程池处理
					getExecutorService().execute(new SocketProcessor(socketChannel));
				}
			}
			selector.selectedKeys().clear();
			selector.selectNow();
		}
		
	}
}

class SocketProcessor implements Runnable {
	
	private SocketChannel socketChannel;
	
	public SocketProcessor(SocketChannel socketChannel) {
		this.socketChannel = socketChannel;
	}

	@Override
	public void run() {
		// 处理线程
		// 分配一个缓冲区用来读取socket的数据
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		
		try {
			// 将channel中的数据写入缓冲区
			socketChannel.read(byteBuffer);
			// 转换缓存区的读写模式
			byteBuffer.flip();
			// 打印缓冲区的数据
			byte[] bytes = byteBuffer.array();
			String str = new String(bytes);
			System.out.println(str);
			
			// 响应数据
			byteBuffer.clear();
			String resp = "this is zxl" + System.currentTimeMillis();
			//System.out.println("服务端线程启动数量：" + ((ThreadPoolExecutor) ZxlNioServer.getExecutorService()).getActiveCount());
			byteBuffer = ByteBuffer.allocate(resp.length());
			byteBuffer.wrap(resp.getBytes());
			socketChannel.write(byteBuffer);
			
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			try {
				socketChannel.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*try {
				socketChannel.register(ZxlNioServer.selector, SelectionKey.OP_READ);
			} catch (ClosedChannelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		
		// TODO Auto-generated method stub
		
	}
	
}
