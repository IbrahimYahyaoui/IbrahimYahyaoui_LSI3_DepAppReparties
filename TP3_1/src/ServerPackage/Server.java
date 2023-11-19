package ServerPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("I am a server waiting for a client connection...");

            Socket socket = serverSocket.accept();

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            System.out.println("Waiting for a number ... ");

            int nb = inputStream.readInt();
            System.out.println("Data received: " + nb);

            int choice = inputStream.readInt();
            int rep;
            	
            switch (choice) {
                case 1:
                    System.out.println("The client selected Addition operation");
                    rep = nb + 5;
                    outputStream.writeInt(rep); // Send the response as an integer
                    break;
                case 2:
                    System.out.println("The client selected Subtraction operation");
                    rep = nb - 5;
                    outputStream.writeInt(rep);
                    break;
                case 3:
                    System.out.println("The client selected Multiplication operation");
                    rep = nb * 5;
                    outputStream.writeInt(rep);
                    break;
                case 4:
                    System.out.println("The client selected Division operation");
                    rep = nb / 5;
                    outputStream.writeInt(rep);
                    break;
                default:
                    System.out.println("Return to Client.");
            }

            System.out.println("Closing the socket...");
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
