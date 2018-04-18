package nio_learn;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

public class IoServer {
	public static void main(String[] args) throws IOException {
		
		ServerSocket ss = new ServerSocket(8080);
		
		while(true) {
			Socket socket = ss.accept();
			byte[] bf = new byte[1024];
			long hasBf = socket.getInputStream().read(bf);
			if(hasBf > 0) {
				System.out.println(new String(bf));
			}
			// 响应客户端
			String response = "zxl  resp" + System.currentTimeMillis();
			socket.getOutputStream().write(response.getBytes());
			socket.getOutputStream().flush();
		}
	}
}
