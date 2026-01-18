package bookMyShow.service;

import bookMyShow.entities.Booking;
import bookMyShow.entities.Seat;
import bookMyShow.entities.Show;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class BookingService {
    private final SeatLockService seatLockService;
    private static volatile BookingService instance;
    private List<Booking> bookings;

    private BookingService(SeatLockService service) {
        this.seatLockService = service;
        this.bookings = new ArrayList<>();
    }
    public static BookingService getInstance(SeatLockService service) {
        if(instance == null) {
            synchronized (BookingService.class) {
                if(instance == null) {
                    instance = new BookingService(service);
                }
            }
        }
        return instance;
    }
    public synchronized boolean bookSeats(Show show, List<Integer> seatIds){
        Map<Integer, Seat> seatMap = show.getSeatStatusMap();
        //Call the seatLockService to lock the seats
        boolean lockSeats = seatLockService.lockSeats(show, seatIds);
        if(!lockSeats) {
            return false;
        }

        //We are not implementing payment logic for now. Let's assume payment is successful
        try {
            boolean payment = true;
            //if payment fails we need to unlock all the seats
            if(!payment) {
                this.seatLockService.unlockSeats(show, seatIds);
                return false;
            }

            //We have locked the seats and the payment has succeeded. Now we need to mark the seats as booked and return the BookingTicket to user
            for(int i=0;i< seatIds.size();i++) {
                seatMap.get(seatIds.get(i)).book();
            }

            Booking booking = new Booking(show, seatIds);
            this.bookings.add(booking);

        } finally {
            this.seatLockService.unlockSeats(show, seatIds);
        }

        return true;
    }

    public List<Booking> getBookings() { return this.bookings; }
}
