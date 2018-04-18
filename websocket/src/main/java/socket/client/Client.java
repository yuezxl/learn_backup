package socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//客户端请求与本机的10086端口简历TCP连接
		Socket client = new Socket("localhost", 10086);
		
		client.setSoTimeout(10000);
		
		//获取键盘输入
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		//获取Socket的输出流，用来发送数据到服务端
		PrintStream out = new PrintStream(client.getOutputStream());
		
		//获取socket的输入了，用来接收服务端发送过来的数据
		BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
		
		boolean flag = true;
		while(flag) {
			String inputInfo = input.readLine();
			System.out.println("输入的信息：" + inputInfo);
			
			//发送数据到服务端
			out.println(inputInfo);
			
			if("bye".equals(inputInfo)) {
				flag = false;
				break;
			}
			
			try {
				String outputInfo = buf.readLine();
				System.out.println(outputInfo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		input.close();  
		if(client != null) {
			client.close();
		}
	}
}
