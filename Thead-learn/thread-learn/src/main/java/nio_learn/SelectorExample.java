package nio_learn;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

public class SelectorExample {
	private static final int BUF_SIZE = 256;
	private static final int TIME_OUT = 3000;
	
	public static void main(String[] args) throws IOException {
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		
		Selector selector = Selector.open();
		
		serverSocketChannel.socket().bind(new InetSocketAddress(8080));
		
		serverSocketChannel.configureBlocking(false);
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		
		while(true) {
			if(selector.select(TIME_OUT) == 0) {
				continue;
			}
			
			Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
			
			while(keyIterator.hasNext()) {
				SelectionKey key = keyIterator.next();
				keyIterator.remove();
				
				if(key.isAcceptable()) {
					SocketChannel clientChannel = ((ServerSocketChannel) key.channel()).accept();
					clientChannel.configureBlocking(false);
					clientChannel.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(BUF_SIZE));
				}
				
				if(key.isReadable()) {
					SocketChannel clientChannel = (SocketChannel) key.channel();
					ByteBuffer buf = (ByteBuffer) key.attachment();
					long bytesRead = clientChannel.read(buf);
					
					if(bytesRead == -1) {
						clientChannel.close();
					} else if(bytesRead > 0) {
						key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
						System.out.println("GET DATA length:" + bytesRead );
						System.out.println("Data:" + byteBuffer2String(buf, Charset.defaultCharset()));
					}
				}
				
				if(key.isValid() && key.isWritable()) {
					String response = "this is zxl" + System.currentTimeMillis();
					ByteBuffer buf = ByteBuffer.allocate(response.length());
					buf.wrap(response.getBytes());
					buf.flip();
					SocketChannel clientChannel = (SocketChannel) key.channel();
					
					clientChannel.write(buf);
					if(!buf.hasRemaining()) {
						key.interestOps(SelectionKey.OP_READ);
					}
					buf.compact();
				}
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
