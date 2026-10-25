import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            CalculatorServiceImpl obj = new CalculatorServiceImpl();

            // Export the remote object - this creates the stub
            CalculatorService stub =
                (CalculatorService) UnicastRemoteObject.exportObject(obj, 0);

            // Create the RMI registry and bind the stub
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("CalculatorService", stub);

            System.out.println("Calculator server is ready...");
            System.out.println("Stub bound in registry as 'CalculatorService'");
            System.out.println("Waiting for client requests...");

        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}