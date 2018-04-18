package nio_learn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 8080);
		
		BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
		
		String request;
		while(true) {
			System.out.print("输入信息：");  
			request = re.readLine();
			socket.getOutputStream().write(request.getBytes());
			socket.getOutputStream().flush();
			
			byte[] response = new byte[1024];
			socket.getInputStream().read(response);
			System.out.println("服务端响应" + new String(response));
		}
	}
}
