import java.io.*;
import java.net.*;

public class Client
{
    public static void main(String[] args)
    {
        try
        {
            // Connect to the server
            Socket socket = new Socket("localhost", 5000);

            // Input stream to receive data from server
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // Output stream to send data to server
            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            // Send message to server
            output.println("Hello Server!");

            // Receive message from server
            String message = input.readLine();

            // Display server response
            System.out.println("Server says: " + message);

            // Close socket
            socket.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}