package parkingLot.vehicle;

import parkingLot.ticket.ParkingTicket;

//abstract class to provide the template for different types of vehicles
public abstract class Vehicle {
    protected String numberPlate;
    protected VehicleType type;
    protected ParkingTicket parkingTicket;

    protected Vehicle(String numberPlate, VehicleType type ) {
        this.numberPlate = numberPlate;
        this.type = type;
    }

    public void assignTicket(ParkingTicket ticket) {
        this.parkingTicket = ticket;
    }
    public VehicleType getVehicleType() {
        return this.type;
    }
    public ParkingTicket getParkingTicket() {
        return this.parkingTicket;
    }
}
