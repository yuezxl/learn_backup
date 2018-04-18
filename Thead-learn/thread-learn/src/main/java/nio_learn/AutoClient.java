package nio_learn;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class AutoClient {
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					String threadName = Thread.currentThread().getName();
					String request = "this is " + threadName + " for request";
					Socket socket  = null;
					
					try {
						socket = new Socket("localhost", 8080);
						while(true) {
							// 向服务端发送消息
							socket.getOutputStream().write(request.getBytes());
							socket.getOutputStream().flush();
							
							//读取服务端的响应
							byte[] response = new byte[1024];
							socket.getInputStream().read(response);
							
							System.out.println("threadName：" + threadName + "----" + new String(response));
						}
						
						
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						if(socket != null) {
							try {
								socket.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					
					
				}
			}).start();
		}
	}
}
