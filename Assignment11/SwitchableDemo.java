interface Switchable
{
    void turnOn();
    void turnOff();
    void displayStatus();
}

class Light implements Switchable
{
    String location;
    int wattage;
    boolean status;

    Light(String location, int wattage)
    {
        this.location = location;
        this.wattage = wattage;
        status = false;
    }

    public void turnOn()
    {
        status = true;
        System.out.println("Light is turned ON.");
    }

    public void turnOff()
    {
        status = false;
        System.out.println("Light is turned OFF.");
    }

    public void displayStatus()
    {
        System.out.println("Device : Light");
        System.out.println("Location : " + location);
        System.out.println("Wattage : " + wattage + " W");
        System.out.println("Status : " + (status ? "ON" : "OFF"));
    }
}

class Fan implements Switchable
{
    String location;
    int speed;
    boolean status;

    Fan(String location, int speed)
    {
        this.location = location;
        this.speed = speed;
        status = false;
    }

    public void turnOn()
    {
        status = true;
        System.out.println("Fan is turned ON.");
    }

    public void turnOff()
    {
        status = false;
        System.out.println("Fan is turned OFF.");
    }

    public void displayStatus()
    {
        System.out.println("Device : Fan");
        System.out.println("Location : " + location);
        System.out.println("Speed : " + speed);
        System.out.println("Status : " + (status ? "ON" : "OFF"));
    }
}

public class SwitchableDemo
{
    public static void main(String[] args)
    {
        Switchable light = new Light("Bedroom", 15);
        Switchable fan = new Fan("Living Room", 3);

        System.out.println("LIGHT DETAILS");
        System.out.println("-------------");
        light.displayStatus();
        light.turnOn();
        light.displayStatus();

        System.out.println();

        System.out.println("FAN DETAILS");
        System.out.println("-----------");
        fan.displayStatus();
        fan.turnOn();
        fan.displayStatus();

        System.out.println();

        light.turnOff();
        fan.turnOff();
    }
}