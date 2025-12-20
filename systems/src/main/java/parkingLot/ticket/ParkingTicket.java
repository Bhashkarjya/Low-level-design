package parkingLot.ticket;

import parkingLot.vehicle.Vehicle;
import parkingLot.payment.PaymentStrategy;
import parkingLot.parkingSpots.ParkingSpot;
import parkingLot.points.Entrance;
import parkingLot.points.Exit;

import java.util.Date;

public class ParkingTicket {
    private String ticketNumber;
    private Vehicle vehicle;
    private Date entryTime;
    private Date exitTime;
    private Entrance entrance;
    private Exit exit;
    private PaymentStrategy paymentStrategy;
    private TicketStatus ticketStatus;
    private ParkingSpot parkingSpot;
    private ParkingTicket(ParkingTicketBuilder builder) {
        this.ticketNumber = builder.ticketNumber;
        this.vehicle = builder.vehicle;
        this.entryTime = builder.entryTime;
        this.exitTime = builder.exitTime;
        this.entrance = builder.entrance;
        this.exit = builder.exit;
        this.paymentStrategy = builder.strategy;
        this.ticketStatus = builder.ticketStatus;
        this.parkingSpot = builder.parkingSpot;
    }

    public String getTicketNumber() {
        return this.ticketNumber;
    }
    public ParkingSpot getParkingSpot() {
        return this.parkingSpot;
    }
    public Entrance getTicketEntrance() {
        return this.entrance;
    }

    public void markExit(Date exitTime) {
        this.exitTime = exitTime;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }
    public void setTicketStatus(TicketStatus status) {
        this.ticketStatus = status;
    }

    public static class ParkingTicketBuilder {
        private String ticketNumber;
        private Vehicle vehicle;
        private Date entryTime;
        private Date exitTime;
        private Entrance entrance;
        private Exit exit;
        private PaymentStrategy strategy;
        private TicketStatus ticketStatus;
        private ParkingSpot parkingSpot;

        public ParkingTicketBuilder setTicketNumber(String ticketNumber) {
            this.ticketNumber = ticketNumber;
            return this;
        }

        public ParkingTicketBuilder setVehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            return this;
        }

        public ParkingTicketBuilder setEntryTime(Date timestamp) {
            this.entryTime = timestamp;
            return this;
        }

        public ParkingTicketBuilder setExitTime(Date timestamp) {
            this.exitTime = timestamp;
            return this;
        }

        public ParkingTicketBuilder setEntrance(Entrance entrance) {
            this.entrance = entrance;
            return this;
        }

        public ParkingTicketBuilder setExit(Exit exit) {
            this.exit = exit;
            return this;
        }

        public ParkingTicketBuilder setPaymentStrategy(PaymentStrategy strategy) {
            this.strategy = strategy;
            return this;
        }

        public ParkingTicketBuilder setTicketStatus(TicketStatus status) {
            this.ticketStatus = status;
            return this;
        }

        public ParkingTicketBuilder setParkingSpot(ParkingSpot spot) {
            this.parkingSpot = spot;
            return this;
        }

        public ParkingTicket build() {
            return new ParkingTicket(this);
        }
    }
}
