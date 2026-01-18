package bookMyShow.entities;

import java.util.List;
public class Booking {
    private Show show;
    private List<Integer> bookedSeats;
    private Payment payment;
    public Booking(Show show, List<Integer> seats) {
        this.show = show;
        this.bookedSeats = seats;
    }

    public void displayBooking() {
        System.out.println("Booking completed :\n" + show.getMovie().getMovieName() + "\n"
        + show.getStartTime() + "\n");
        System.out.println("Booked Seats");
        for(Integer i : bookedSeats) {
            System.out.println(i + " ");
        }
    }

}
