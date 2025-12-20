package parkingLot.points;

import java.util.Date;

import parkingLot.components.DisplayBoard;
import parkingLot.ticket.ParkingTicket;
import parkingLot.ticket.TicketStatus;
import parkingLot.vehicle.Vehicle;
import parkingLot.parkingSpots.ParkingSpot;

public class Entrance {
    private String id;
    private DisplayBoard displayBoard;
    public Entrance(String id) {
        this.id = id;
    }
    public ParkingTicket getParkingTicket(Vehicle vehicle, Date entranceTime, Entrance entrance, ParkingSpot spot) {
        ParkingTicket ticket = new ParkingTicket.ParkingTicketBuilder()
                .setTicketNumber("2")
                .setVehicle(vehicle)
                .setEntrance(entrance)
                .setEntryTime(entranceTime)
                .setParkingSpot(spot)
                .setTicketStatus(TicketStatus.ISSUED)
                .build();
        return ticket;
    }

    public String getEntranceId() {
        return this.id;
    }

    public DisplayBoard getDisplayBoard() {
        return this.displayBoard;
    }
}
