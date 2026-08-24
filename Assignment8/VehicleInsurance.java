class Vehicle {
    String vehicleNumber;
    String ownerName;
    double vehicleValue;

    Vehicle(String vehicleNumber, String ownerName, double vehicleValue) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.vehicleValue = vehicleValue;
    }

    void displayVehicleDetails() {
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Owner Name     : " + ownerName);
        System.out.println("Vehicle Value  : Rs. " + vehicleValue);
    }

    double calculateBasicPremium() {
        return vehicleValue * 0.02;
    }
}

class CarInsurance extends Vehicle {
    int seatingCapacity;

    CarInsurance(String vehicleNumber, String ownerName,
                 double vehicleValue, int seatingCapacity) {

        super(vehicleNumber, ownerName, vehicleValue);

        this.seatingCapacity = seatingCapacity;
    }

    @Override
    double calculateBasicPremium() {
        return super.calculateBasicPremium();
    }

    void displayInsuranceDetails() {
        System.out.println("\nCar Insurance Details");
        System.out.println("---------------------");

        super.displayVehicleDetails();

        System.out.println("Seating Capacity : " + seatingCapacity);
        System.out.println("Insurance Premium: Rs. "
                + calculateBasicPremium());
    }
}

class BikeInsurance extends Vehicle {
    boolean hasAccidentCover;

    BikeInsurance(String vehicleNumber, String ownerName,
                  double vehicleValue, boolean hasAccidentCover) {

        super(vehicleNumber, ownerName, vehicleValue);

        this.hasAccidentCover = hasAccidentCover;
    }

    @Override
    double calculateBasicPremium() {
        double premium = super.calculateBasicPremium();

        if (hasAccidentCover) {
            premium += 1500;
        }

        return premium;
    }

    void displayInsuranceDetails() {
        System.out.println("\nBike Insurance Details");
        System.out.println("----------------------");

        super.displayVehicleDetails();

        System.out.println("Accident Cover : "
                + (hasAccidentCover ? "Yes" : "No"));

        System.out.println("Insurance Premium: Rs. "
                + calculateBasicPremium());
    }
}

public class VehicleInsurance {
    public static void main(String[] args) {

        CarInsurance car = new CarInsurance(
                "MH12AB1234",
                "Rahul",
                800000,
                5
        );

        BikeInsurance bike = new BikeInsurance(
                "MH14XY5678",
                "Aman",
                150000,
                true
        );

        car.displayInsuranceDetails();

        bike.displayInsuranceDetails();
    }
}