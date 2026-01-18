package bookMyShow.service;

import bookMyShow.entities.Screen;
import bookMyShow.entities.Theatre;
import bookMyShow.enums.City;
import bookMyShow.entities.Movie;
import bookMyShow.entities.Show;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreService {
    private Map<City, List<Theatre>> theatreList;
    private static volatile TheatreService instance;
    private List<Theatre> allTheatres;
    private TheatreService() {
        this.allTheatres = new ArrayList<>();
        this.theatreList = new HashMap<>();
    }

    public static TheatreService getInstance() {
        if(instance == null) {
            synchronized (TheatreService.class) {
                if(instance == null) {
                    instance = new TheatreService();
                }
            }
        }
        return instance;
    }

    public void addTheatre(City city, Theatre theatre) {
        this.allTheatres.add(theatre);
        List<Theatre> theatres = this.theatreList.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        this.theatreList.put(city, theatres);
    }

    public List<Theatre> getTheatresInACity(City city) {
        return this.theatreList.get(city);
    }

    public List<Show> getAllShows(LocalDate date, Theatre theatre) {
        return theatre.getShowsList().stream().filter(
                show -> show.getStartTime().toLocalDate().equals(date)
        ).toList();
    }
}
