package bookMyShow;

import bookMyShow.entities.Booking;
import bookMyShow.entities.Movie;
import bookMyShow.entities.Screen;
import bookMyShow.entities.Seat;
import bookMyShow.entities.Show;
import bookMyShow.entities.Theatre;
import bookMyShow.enums.City;
import bookMyShow.enums.SeatType;
import bookMyShow.service.BookingService;
import bookMyShow.service.MovieService;
import bookMyShow.service.SeatLockService;
import bookMyShow.service.TheatreService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookMyShowApp {
    public static void main(String[] args){
        SeatLockService seatLockService = SeatLockService.getInstance();
        BookingService bookingService = BookingService.getInstance(seatLockService);
        TheatreService theatreService = TheatreService.getInstance();
        MovieService movieService = MovieService.getInstance(theatreService);

        //Create theatres
        Theatre theatre1 = new Theatre(1, "A", City.DELHI);
        Theatre theatre2 = new Theatre(2, "B", City.DELHI);
        theatreService.addTheatre(City.DELHI, theatre1);
        theatreService.addTheatre(City.DELHI, theatre2);

        //Add screens to the theatre
        Screen s1 = theatre1.addScreen(1);
        Screen s2 = theatre1.addScreen(2);
        Screen s3 = theatre2.addScreen(1);
        Screen s4 = theatre2.addScreen(2);

        //Create seats in the screens
        List<Seat> seats = createSeats();
        s1.setSeats(seats);
        s2.setSeats(seats);
        s3.setSeats(seats);
        s4.setSeats(seats);

        //Create movie objects
        Movie Bahubali = new Movie("Bahubali", 120);
        Movie Dhurandhar = new Movie("Dhurandhar", 200);
        Movie Avenger = new Movie("Avenger", 150);

        LocalDateTime time1 = LocalDateTime.now().minusDays(1);
        LocalDateTime time2 = LocalDateTime.now();

        //Add shows to the theatre
        Show show1 = theatre1.addShow(time1, Bahubali, s1);
        Show show2 = theatre1.addShow(time1, Dhurandhar, s2);
        Show show3 = theatre1.addShow(time2, Avenger, s1);

        //Call theatre and movie services
        List<Show> shows = theatreService.getAllShows(time1.toLocalDate(), theatre1);
        for(Show show : shows) {
            System.out.println(show.getMovie().getMovieName() + " --- " + show.getStartTime());
        }
        List<Theatre> theatreList = theatreService.getTheatresInACity(City.DELHI);
        for(Theatre t : theatreList) {
            System.out.println(t.getTheatreName());
        }

        List<Movie> movies = movieService.getMoviesRunningInACity(City.DELHI);
        for(Movie movie : movies) {
            System.out.println(movie.getMovieName());
        }
        List<Theatre> theatresForMovie = movieService.getTheatresForMovie(City.DELHI, Bahubali, time1.toLocalDate());
        for(Theatre t : theatresForMovie) {
            System.out.println(t.getTheatreName());
        }

        //Book seats
        bookingService.bookSeats(show1, Arrays.asList(1,2,3));
        bookingService.bookSeats(show1, Arrays.asList(3,4));

        List<Booking> bookingList = bookingService.getBookings();
        for(Booking b : bookingList) {
            b.displayBooking();
        }
    }

    private static List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            Seat seat = new Seat(i, SeatType.SILVER);
            seats.add(seat);
        }

        for (int i = 40; i < 70; i++) {
            Seat seat = new Seat(i, SeatType.GOLD);
            seats.add(seat);
        }

        for(int i=70;i<=100;i++) {
            Seat seat = new Seat(i, SeatType.PLATINUM);
            seats.add(seat);
        }

        return seats;
    }
}
