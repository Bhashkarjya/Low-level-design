package parkingLot.vehicle;

import parkingLot.ticket.ParkingTicket;

public class Car extends Vehicle {

    public Car(String numberplate) {
        super(numberplate, VehicleType.CAR);
    }
}
