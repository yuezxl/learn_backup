package nio_learn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestClient {
	    /**
	     * @param args
	     * @throws IOException 
	     * @throws UnknownHostException 
	     * @throws InterruptedException 
	     */
	    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {

	        final Socket socket = new Socket("localhost", 12345);
	        Thread inT = new Thread(new Runnable() {
	            @Override
	            public void run() {
	                try {
	                    while(true) {
	                        InputStream inputStream = socket.getInputStream();
	                        byte[] b = new byte[8192];
	                        int readSize = inputStream.read(b);
	                        System.out.println(new String(b,0,readSize));
	                    }
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	        inT.start();
	        while(true) {
	            InputStreamReader stdin = new InputStreamReader(System.in);//键盘输入 
	            BufferedReader bufin = new BufferedReader(stdin); 
	            String str = bufin.readLine(); 

	            OutputStream outStream = socket.getOutputStream();
	            outStream.write(str.getBytes());
	            outStream.flush();
	        }

	    }

	}