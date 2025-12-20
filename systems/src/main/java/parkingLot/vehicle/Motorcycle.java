package parkingLot.vehicle;

import parkingLot.ticket.ParkingTicket;

public class Motorcycle extends Vehicle {

    public Motorcycle(String numberplate) {
        super(numberplate, VehicleType.MOTORCYCLE);
    }
}
