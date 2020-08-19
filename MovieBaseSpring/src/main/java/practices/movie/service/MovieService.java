package practices.movie.service;
import org.springframework.http.ResponseEntity;
import practices.movie.model.Movie;

public interface MovieService {

    void getMovies();
    void getMovie(Long id);
    void addMovie(Movie movie);
    void updateMovie(Movie movie, Long id);
    void deleteMovie(Long id);

}
