package ClientJava;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
	            System.out.println("Je suis un client");
	            Socket s = new Socket("localhost", 1232);
	            System.out.println("Je suis connecté au serveur");

	           
	            Scanner scanner = new Scanner(System.in);
	            System.out.print("Entrez l'opération (ex. 34 * 55) : ");
	            String operation = scanner.nextLine();

	            
	            OutputStream os = s.getOutputStream();
	            PrintWriter pw = new PrintWriter(os, true);
	            pw.println(operation);
	            

	       
	            InputStream is = s.getInputStream();

	            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
	            String result = in.readLine();
	            System.out.println("Résultat : " + result);
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	}

}
