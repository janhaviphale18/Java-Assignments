import java.rmi.RemoteException;

public class CalculatorServiceImpl implements CalculatorService {

    public double add(double a, double b) throws RemoteException {
        System.out.println("Request received: add(" + a + ", " + b + ")");
        return a + b;
    }

    public double subtract(double a, double b) throws RemoteException {
        System.out.println("Request received: subtract(" + a + ", " + b + ")");
        return a - b;
    }

    public double multiply(double a, double b) throws RemoteException {
        System.out.println("Request received: multiply(" + a + ", " + b + ")");
        return a * b;
    }

    public double divide(double a, double b) throws RemoteException {
        System.out.println("Request received: divide(" + a + ", " + b + ")");
        return a / b;
    }
}