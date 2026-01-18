package bookMyShow.entities;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Show {
    private final Movie movie;
    private final LocalDateTime startTime;
    private Map<Integer, Seat> seatBookings;
    private Screen screen;

    public Show(Movie movie, LocalDateTime startTime, Screen screen) {
        this.movie = movie;
        this.startTime = startTime;
        this.screen = screen;
        this.seatBookings = new HashMap<>();
    }

    public Movie getMovie() { return this.movie;}
    public LocalDateTime getStartTime() { return  this.startTime; }
    public Map<Integer, Seat> getSeatStatusMap() { return this.seatBookings; }
    public void initializeSeats() {
        List<Seat> seats = this.screen.getSeats();
        for(int i=0;i<seats.size();i++) {
            this.seatBookings.put(i, seats.get(i));
        }
    }
}
