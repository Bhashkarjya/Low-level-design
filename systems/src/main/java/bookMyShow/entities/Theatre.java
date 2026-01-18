package bookMyShow.entities;

import bookMyShow.enums.City;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private int theatreId;
    private String theatreName;
    private final City city;
    private final List<Screen> screenList;
    private final List<Show> showsList;

    public Theatre(int id, String name, City city) {
        this.theatreId = id;
        this.city = city;
        this.theatreName = name;
        this.screenList = new ArrayList<>();
        this.showsList = new ArrayList<>();
    }

    public String getTheatreName() { return this.theatreName; }
    public City getCity() { return this.city; }
    public int getTheatreId() { return this.theatreId; }
    public List<Screen> getScreenList() { return this.screenList; }
    public List<Show> getShowsList() { return this.showsList; }
    public void setTheatreName(String name) { this.theatreName = name; }
    public Screen addScreen(int screenId) {
        Screen screen = new Screen(screenId);
        this.screenList.add(screen);
        return screen;
    }

    public Show addShow(LocalDateTime time, Movie movie, Screen screen) {
        Show show = new Show(movie, time, screen);
        show.initializeSeats();
        this.showsList.add(show);
        screen.getShows().put(time.toLocalDate(), show);
        return show;
    }

}
