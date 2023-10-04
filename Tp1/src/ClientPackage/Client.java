package ClientPackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
			try 
			{
				 System.out.println("je suis un client encore connecte");
				 Socket socket = new Socket("localhost", 1234); 
				 
		          InputStream inputStream = socket.getInputStream();
		          OutputStream outputStream = socket.getOutputStream();

		          System.out.println("je suis un client connecte");
		           
		            
		            
			} catch( IOException e) {
				e.printStackTrace();
			}
	}

}
