package dto;

/**
 *
 * @author rando
 */
public class CompleteDTO {
    private final String movieReleased;
    private final String movieRuntime;
    private final String movieTitle;
    private final Object joke;
    private final String kanyeRest;

    public CompleteDTO(OmdbApiDTO omdb, ICNDbDTO icndb, KanyeRestDTO kanye) {
        this.movieReleased = omdb.getReleased();
        this.movieRuntime = omdb.getRuntime();
        this.movieTitle = omdb.getTitle();
        this.joke = icndb.getValue();
        this.kanyeRest = kanye.getQuote();
    }

    public String getMovieReleased() {
        return movieReleased;
    }

    public String getMovieRuntime() {
        return movieRuntime;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public Object getJoke() {
        return joke;
    }

    public String getKanyeRest() {
        return kanyeRest;
    }

    @Override
    public String toString() {
        return "CompleteDTO{" + "Movie released=" + movieReleased + ", Movie runtime=" + movieRuntime + ", Movie title=" + movieTitle + ", Joke=" + joke + ", KanyeRest=" + kanyeRest + '}';
    }

}
