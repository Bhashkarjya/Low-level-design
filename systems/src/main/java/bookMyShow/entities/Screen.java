package bookMyShow.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Screen {
    private int screenId;
    private List<Seat> seats;
    private Map<LocalDate, Show> shows;
    public Screen(int screenId) {
        this.screenId = screenId;
        this.shows = new HashMap<>();
    }

    public int getScreenId() {
        return this.screenId;
    }

    public List<Seat> getSeats() {
        return this.seats;
    }

    public Map<LocalDate, Show> getShows() {
        return this.shows;
    }
    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public void displayShows() {
        System.out.println("Shows on " + this.screenId);
        for(Map.Entry<LocalDate, Show> entry : this.shows.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getKey().toString());
        }
    }
}
