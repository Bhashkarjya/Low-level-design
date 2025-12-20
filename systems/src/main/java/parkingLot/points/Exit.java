package parkingLot.points;

import parkingLot.ticket.ParkingTicket;

public class Exit {
    private String id;
    public Exit(String id) {
        this.id = id;
    }
    public boolean processPayment(ParkingTicket ticket) {
        return true;
    }

    public String getExitId() {
        return this.id;
    }
}
