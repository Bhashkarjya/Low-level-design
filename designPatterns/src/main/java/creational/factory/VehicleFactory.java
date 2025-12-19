package creational.factory;

public class VehicleFactory {
    public static Vehicle getVehicle(String carType) {
        if(carType.equals("Car")) {
            return new Car();
        }
        else if(carType.equals("Bike")) {
            return new Bike();
        }
        else {
            throw new IllegalArgumentException("Unknown vehicle type");
        }
    }
}
