package parkingLot.vehicle;

import parkingLot.ticket.ParkingTicket;

public class Truck extends Vehicle {

    public Truck(String numberplate) {
        super(numberplate, VehicleType.TRUCK);
    }
}
