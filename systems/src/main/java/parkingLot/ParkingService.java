package parkingLot;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

import parkingLot.components.ParkingRate;
import parkingLot.parkingSpots.ParkingSpot;
import parkingLot.parkingSpots.ParkingSpotType;
import parkingLot.points.Entrance;
import parkingLot.points.Exit;
import parkingLot.components.DisplayBoard;
import parkingLot.ticket.ParkingTicket;
import parkingLot.payment.PaymentStrategy;
import parkingLot.ticket.TicketStatus;
import parkingLot.vehicle.Vehicle;
import parkingLot.vehicle.VehicleType;

public class ParkingService {
    private int id;
    private String name;
    private ParkingRate parkingRate;
    private Map<String, Entrance> entrances;
    private Map<String, Exit> exits;
    private Map<String, ReentrantLock> entranceLocks;
    private List<DisplayBoard> displayBoards;
    private Map<String, ParkingTicket> parkingTickets;

    // For each entrance and spot type, store the nearest spots first
    private Map<String, Map<ParkingSpotType, PriorityQueue<ParkingSpot>>> availableSpots;
    private static final Map<VehicleType, List<ParkingSpotType>> mapping =
            Map.of(
                    VehicleType.CAR,
                    List.of(ParkingSpotType.COMPACT, ParkingSpotType.LARGE),
                    VehicleType.MOTORCYCLE,
                    List.of(ParkingSpotType.MOTORCYCLE, ParkingSpotType.COMPACT),
                    VehicleType.TRUCK,
                    List.of(ParkingSpotType.LARGE)
            );

    private static ParkingService service;
    private ParkingService() {
        entrances = new ConcurrentHashMap<>();
        exits = new ConcurrentHashMap<>();
        displayBoards = new ArrayList<>();
        parkingTickets = new ConcurrentHashMap<>();
        availableSpots = new ConcurrentHashMap<>();
    }

    public static ParkingService getParkingService() {
        if (service == null) {
            synchronized (ParkingService.class) {
                if(service == null) {
                    service = new ParkingService();
                }
            }
        }
        return service;
    }

    public void addEntrance(Entrance entrance) {
        this.entrances.put(entrance.getEntranceId(), entrance);
        this.entranceLocks.put(entrance.getEntranceId(), new ReentrantLock());
        this.availableSpots.putIfAbsent(entrance.getEntranceId(), new ConcurrentHashMap<>());
    }
    public void addExit(Exit exit) {
        this.exits.put(exit.getExitId(), exit);
    }

    public void removeEntrance(Entrance entrance) {
        this.entrances.remove(entrance.getEntranceId());
    }

    public void removeExit(Exit exit) {
        this.exits.remove(exit.getExitId());
    }

//    public void addParkingSpot(ParkingSpot spot) {
//        this.parkingSpots.put(spot.getParkingSpotId(), spot);
//    }

    public void addDisplayBoard(DisplayBoard board) {
        displayBoards.add(board);
    }

    /* This method is executed when a new vehicle enters the parking lot
    1. Check if the parking spot is available for the particular type of vehicle
    2. Assign a parking spot to the vehicle
    3. Generate a ticket to the vehicle
    4. Update the display board
    */
    public void processEntry(Vehicle vehicle, Date entranceTime, Entrance entrance) throws Exception{
        ReentrantLock lock = entranceLocks.get(entrance.getEntranceId());
        lock.lock();
        try {
            if (isFull(vehicle.getVehicleType())) {
                throw new Exception("Parking spot is full for the particular vehicle type");
            }
            ParkingSpot parkingSpot = assignParkingSpot(vehicle, entrance);
            parkingSpot.assignVehicle(vehicle);

            ParkingTicket ticket = generateTicket(vehicle, entranceTime, entrance, parkingSpot);
            vehicle.assignTicket(ticket);

            entrance.getDisplayBoard().onEntryUpdate(ticket.getParkingSpot().getParkingSpotType());
            this.parkingTickets.put(ticket.getTicketNumber(), ticket);
        }
        finally {
            lock.unlock();
        }
    }

    /* This method is executed when a vehicle exits the parking lot
    1. Calculate the amount to be paid
    2. Empty the parkingSlot occupied by this vehicle
    3. Update the display board
     */
    public void processExit(Exit exit, ParkingTicket ticket, PaymentStrategy strategy) throws Exception{

        ParkingSpot parkingSpot = ticket.getParkingSpot();
        Entrance entrance = ticket.getTicketEntrance();
        ReentrantLock lock = entranceLocks.get(entrance.getEntranceId());
        lock.lock();
        try {
            ticket.markExit(new Date());

            boolean paymentProcess = processPayment(ticket, strategy);

            if(!paymentProcess) {
                throw new RuntimeException("Payment failed");
            }
            ticket.setTicketStatus(TicketStatus.PAID);
            //Remove the vehicle from the parking spot. The parking spot is again available for use.
            parkingSpot.removeVehicle();

            //Add the parking spot to the priority queue of the entrance
            this.availableSpots.get(entrance.getEntranceId()).get(parkingSpot.getParkingSpotType()).add(parkingSpot);

            //Update the display board
            entrance.getDisplayBoard().onExitUpdate(parkingSpot.getParkingSpotType());
            ticket.setTicketStatus(TicketStatus.VALIDATED);
        }
        finally {
            lock.unlock();
        }
    }

    public ParkingTicket generateTicket(Vehicle vehicle, Date entranceTime, Entrance entrance, ParkingSpot spot) {
        ParkingTicket ticket = entrance.getParkingTicket(vehicle, entranceTime, entrance, spot);
        return ticket;
    }

    // This method holds the logic of assigning spots in a parking lot

    private ParkingSpot assignParkingSpot(Vehicle vehicle, Entrance entrance) {
        VehicleType type = vehicle.getVehicleType();
        List<ParkingSpotType> allowedTypes = mapping.get(type);
        Map<ParkingSpotType, PriorityQueue<ParkingSpot>> entranceMap = this.availableSpots.get(entrance.getEntranceId());

        for(ParkingSpotType spotTypes : allowedTypes) {
            PriorityQueue<ParkingSpot> spotsQueue = entranceMap.get(spotTypes);
            if(spotsQueue != null && !spotsQueue.isEmpty()) {
                return spotsQueue.poll();
            }
        }
        throw new RuntimeException("No available spot");
    }

    public boolean processPayment(ParkingTicket ticket, PaymentStrategy strategy) {
        double fee = this.parkingRate.calculateFree(3.5, ticket.getVehicle(), ticket.getParkingSpot());
        return strategy.pay(fee);
    }

    //This method checks if there are empty ParkingSlots for a particular VehicleType
    public boolean isFull(VehicleType type) {
        return false;
    }
}
