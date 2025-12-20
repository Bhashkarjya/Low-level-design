package parkingLot.parkingSpots;

import parkingLot.vehicle.Vehicle;
public abstract class ParkingSpot {
    protected int id;
    private Vehicle vehicle;
    private ParkingSpotType parkingSpotType;
    public boolean isFree() {
        return this.vehicle == null;
    }

    protected ParkingSpot(int id) {
        this.id = id;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public void removeVehicle() {
        this.vehicle = null;
    }

    public int getParkingSpotId() {
        return this.id;
    }

    public ParkingSpotType getParkingSpotType() {
        return this.parkingSpotType;
    }
}
