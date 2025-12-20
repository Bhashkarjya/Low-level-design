package parkingLot.vehicle;

public class VehicleFactory {
    public static Vehicle getVehicle(VehicleType type, String numberPlate) {
        return switch(type) {
            case CAR -> new Car(numberPlate);
            case TRUCK -> new Truck(numberPlate);
            case MOTORCYCLE -> new Motorcycle(numberPlate);
        };
    }
}
