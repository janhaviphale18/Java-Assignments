import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class TemperatureServer {
    public static void main(String[] args) {
        try {
            TemperatureServiceImpl obj = new TemperatureServiceImpl();

            // Export the remote object - this creates the stub
            TemperatureService stub =
                (TemperatureService) UnicastRemoteObject.exportObject(obj, 0);

            // Create the RMI registry and bind the stub
            Registry registry = LocateRegistry.createRegistry(1100);
            registry.rebind("TemperatureService", stub);

            System.out.println("Temperature converter server is ready...");
            System.out.println("Stub bound in registry as 'TemperatureService'");
            System.out.println("Waiting for client requests...");

        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}