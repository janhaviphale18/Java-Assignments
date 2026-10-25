import java.rmi.RemoteException;

public class TemperatureServiceImpl implements TemperatureService {

    public double celsiusToFahrenheit(double celsius)
            throws RemoteException {
        System.out.println(
            "Request received: Celsius to Fahrenheit for " + celsius
        );

        return (celsius * 9 / 5) + 32;
    }

    public double fahrenheitToCelsius(double fahrenheit)
            throws RemoteException {
        System.out.println(
            "Request received: Fahrenheit to Celsius for " + fahrenheit
        );

        return (fahrenheit - 32) * 5 / 9;
    }
}