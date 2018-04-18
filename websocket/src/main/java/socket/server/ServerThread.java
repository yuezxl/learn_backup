package socket.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import org.apache.commons.lang3.StringUtils;

public class ServerThread implements Runnable{
	
	private Socket client = null;
	
	public ServerThread(Socket client) {
		this.client = client;
	}

	public void run() {
		try {
			//获取socket的输出流，用来想客户端发送数据
			PrintStream out = new PrintStream(client.getOutputStream());
			
			//获取socket的输入流，用来接收客户端发送过来的数据
			BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			boolean flag = true;
			while(flag) {
				String clientInfo = buf.readLine();
				
				if(StringUtils.isBlank(clientInfo) || "bye".equals(clientInfo)) {
					flag = false;
					break;
				}
				
				out.println("ehco:" + clientInfo);
			}
			
			out.close();
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
