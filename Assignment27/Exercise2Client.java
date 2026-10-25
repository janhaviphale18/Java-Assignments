import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Exercise2Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5001);

            BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );

            PrintWriter output = new PrintWriter(
                socket.getOutputStream(), true
            );

            Scanner keyboard = new Scanner(System.in);

            System.out.print("Enter a message: ");
            String message = keyboard.nextLine();

            output.println(message);

            String response = input.readLine();

            System.out.println("Echo from server: " + response);

            input.close();
            output.close();
            socket.close();

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}