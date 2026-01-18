package bookMyShow.entities;

public class Movie {
    private String movieName;
    private int duration;

    public Movie(String name, int duration) {
        this.movieName = name;
        this.duration = duration;
    }

    public String getMovieName() { return this.movieName; }
    public int getDuration() { return this.duration; }
}
