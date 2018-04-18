package nio_learn;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class NioSocketServer {
	
	public static ServerSocketChannel serverSocketChannel;
	public static Selector selector;
	
	public static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(25, 50, 60, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
	
	public static void main(String[] args) throws IOException {
		serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(false);
		serverSocketChannel.bind(new InetSocketAddress(8080));
		
		selector = Selector.open();
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		System.out.println("服务器启动成功！");
		
		while(true) {
			selector.select(200);
			
			
			Set<SelectionKey> selectionKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = selectionKeys.iterator();
			
			while(iterator.hasNext()) {
				SelectionKey selectionKey = iterator.next();
				if(selectionKey.isAcceptable()) {
					SocketChannel connect = serverSocketChannel.accept();
					connect.configureBlocking(false);
					
					connect.register(selector, SelectionKey.OP_READ);
					System.out.println("建立新的连接 ");
				}
				
				if(selectionKey.isReadable()) {
					SocketChannel connect = (SocketChannel) selectionKey.channel();
					
					selectionKey.cancel();
					connect.configureBlocking(false);
					
					threadPoolExecutor.execute(new NioSocketProessor(connect));
				}
			}
			selectionKeys.clear();
			selector.selectNow();
		}
		
	}
}

class NioSocketProessor implements Runnable {
	
	SocketChannel socketChannel;
	
	public NioSocketProessor(SocketChannel socketChannel) {
		this.socketChannel = socketChannel;
	}

	@Override
	public void run() {
		// Nio处理
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		try {
			long bytesRead = socketChannel.read(byteBuffer);
			if(bytesRead > 0) {
				//key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
				System.out.println("GET DATA length:" + bytesRead );
				System.out.println("当前活跃线程数：" + NioSocketServer.threadPoolExecutor.getActiveCount() + "   Data:" + byteBuffer2String(byteBuffer, Charset.defaultCharset()));
				// 响应内容
				byteBuffer.flip();
				byteBuffer.clear();
				byte[] response = ("this is zxl " + Thread.currentThread().getName() + System.currentTimeMillis()).getBytes();
				ByteBuffer resp = ByteBuffer.wrap(response);
				socketChannel.write(resp);
				resp.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
			//长连接，响应后不关闭
		} finally {
			try {
				socketChannel.register(NioSocketServer.selector, SelectionKey.OP_READ);
			} catch (ClosedChannelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public static String byteBuffer2String(ByteBuffer buf, Charset charset) {
		byte[] bytes;
		if (buf.hasArray()) {
			bytes = buf.array();
		} else {
			buf.rewind();
			bytes = new byte[buf.remaining()];
		}
		return new String(bytes, charset);
	}
	
}
