import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Exercise1Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);

            System.out.println("Connected to chat server.");

            Scanner keyboard = new Scanner(System.in);

            PrintWriter output = new PrintWriter(
                socket.getOutputStream(), true
            );

            Scanner input = new Scanner(socket.getInputStream());

            System.out.print("Enter your message: ");
            String message = keyboard.nextLine();

            output.println(message);

            String reply = input.nextLine();
            System.out.println("Server: " + reply);

            input.close();
            output.close();
            socket.close();

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}