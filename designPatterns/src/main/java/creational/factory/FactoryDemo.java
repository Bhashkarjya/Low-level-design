package creational.factory;

import java.util.*;
public class FactoryDemo {
    public static void main(String[] args) {
        Vehicle vehicle1 = VehicleFactory.getVehicle("Bike");
        vehicle1.start();
        vehicle1.stop();

        Vehicle vehicle2 = VehicleFactory.getVehicle("Car");
        vehicle1.start();
        vehicle2.stop();
    }
}
