package ClientPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            int rep, choice = 0;
            System.out.println("I am a client not yet connected ... ");

            InetAddress serverInetAddress = InetAddress.getByName("localhost");
            InetSocketAddress serverSocketAddress = new InetSocketAddress(serverInetAddress, 1234);

            Socket socket = new Socket();
            socket.connect(serverSocketAddress);
            System.out.println("Establish a connection to the server");

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            System.out.println("Give a number:");
            int nb = scanner.nextInt();
            outputStream.writeInt(nb); // Send an integer

            do {
                System.out.println("Menu:");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");

                System.out.print("Enter your choice: ");

                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice < 1 || choice > 4)
                        System.out.println("Invalid input. Please enter a number corresponding to your choice.");
                }

            } while (choice < 1 || choice > 4);

            outputStream.writeInt(choice); // Send the choice as an integer

            System.out.println("I'm waiting for the response from the server");
            rep = inputStream.readInt(); // Read the response as an integer

            switch (choice) {
                case 1:
                    System.out.println("You selected Addition operation");
                    System.out.println("Response = " + nb + " + 5 = " + rep);
                    break;
                case 2:
                    System.out.println("You selected Subtraction operation");
                    System.out.println("Response = " + nb + " - 5 = " + rep);
                    break;
                case 3:
                    System.out.println("You selected Multiplication operation");
                    System.out.println("Response = " + nb + " * 5 = " + rep);
                    break;
                case 4:
                    System.out.println("You selected Division operation");
                    System.out.println("Response = " + nb + " / 5 = " + rep);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
            System.out.println("Closing the client socket...");
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
