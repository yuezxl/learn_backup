package socket.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		//创建服务端端口，监听客户端请求的TCP链接
		ServerSocket server = new ServerSocket(10086);
		
		Socket client = null;
		
		Boolean flag = true;
		
		while(flag) {
			//等待简历客户端的连接
			client = server.accept();
			System.out.println("连接成功");
			//为每个客户端开启一个单独的线程
			new Thread(new ServerThread(client)).start();  
		}
		server.close();
	}
}
