package bookMyShow.service;

import bookMyShow.entities.Movie;
import bookMyShow.entities.Theatre;
import bookMyShow.entities.Screen;
import bookMyShow.entities.Show;
import bookMyShow.enums.City;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MovieService {
    private final TheatreService theatreService;
    private static volatile MovieService instance;

    private MovieService(TheatreService theatreController) {
        this.theatreService = theatreController;
    }
    public static MovieService getInstance(TheatreService controller) {
        if(instance == null) {
            synchronized (MovieService.class) {
                if(instance == null) {
                    instance = new MovieService(controller);
                }
            }
        }
        return instance;
    }

    public List<Movie> getMoviesRunningInACity(City city) {
        Set<Movie> moviesSet = new HashSet<>();
        List<Theatre> theatreList = this.theatreService.getTheatresInACity(city);
        for(Theatre theatre : theatreList) {
            for(Screen screen : theatre.getScreenList()) {
                for(Map.Entry<LocalDate, Show> entry : screen.getShows().entrySet()) {
                    moviesSet.add(entry.getValue().getMovie());
                }
            }
        }

        return moviesSet.stream().toList();
    }

    public List<Theatre> getTheatresForMovie(City city, Movie movie, LocalDate date) {
        List<Theatre> theatreList = new ArrayList<>();
        for(Theatre theatre : this.theatreService.getTheatresInACity(city)) {
            List<Show> shows = this.theatreService.getAllShows(date, theatre);
            for(Show show : shows) {
                if(show.getMovie() == movie) {
                    theatreList.add(theatre);
                }
            }
        }
        return theatreList;
    }
}
