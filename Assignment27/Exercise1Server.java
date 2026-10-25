import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Exercise1Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);

            System.out.println("Chat server started...");
            System.out.println("Waiting for client...");

            Socket socket = server.accept();
            System.out.println("Client connected!");

            Scanner input = new Scanner(socket.getInputStream());

            PrintWriter output = new PrintWriter(
                socket.getOutputStream(), true
            );

            Scanner keyboard = new Scanner(System.in);

            String message = input.nextLine();
            System.out.println("Client: " + message);

            System.out.print("Enter reply: ");
            String reply = keyboard.nextLine();

            output.println(reply);
            System.out.println("Reply sent to client.");

            input.close();
            output.close();
            socket.close();
            server.close();

        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}