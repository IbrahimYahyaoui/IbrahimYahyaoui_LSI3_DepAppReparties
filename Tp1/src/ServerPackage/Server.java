package ServerPackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		
		try {
			ServerSocket ss = new ServerSocket(1234);
			System.out.println("je suis un serveur");
			Socket s = ss.accept();
			InputStream IS = s.getInputStream();
			OutputStream OS = s.getOutputStream();
			
		}catch (IOException e){
			e.printStackTrace();
		}
	}

}
