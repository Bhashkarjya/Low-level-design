package parkingLot.components;

import parkingLot.vehicle.Vehicle;
import parkingLot.parkingSpots.ParkingSpot;
public class ParkingRate {
    private double hourlyRate;
    private double minuteRate;

    public double calculateFree(double duration, Vehicle vehicle, ParkingSpot spot) {
        // The parkingLot should have a pre-defined mechanism to calculate the rate based on the time duration, vehicle type and parkingSpot
        return 0.0;
    }
}
