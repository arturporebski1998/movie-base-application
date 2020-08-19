package practices.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practices.movie.model.Movie;
import practices.movie.repository.MovieRepository;
import practices.movie.service.MovieService;

import java.util.Optional;


// Użycie adnotacji @GetMapping/post etc a nad klasą dać @RequestMapping wspólny dla wszystkich
@RestController
@CrossOrigin(origins = "*")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieService movieService;

    public MovieController(MovieRepository movieRepository, MovieService movieService) {
        this.movieRepository = movieRepository;
        this.movieService = movieService;
    }
    //zrobić lepiej, nie można wsadzić voida (1) do Returna Response Entity
    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public ResponseEntity<Movie> getMovies() {
        this.movieService.getMovies();// (1)
        return new ResponseEntity(this.movieRepository.findAll(), HttpStatus.FOUND);
    }

    //zrobić lepiej, nie można wsadzić voida (2) do Returna Response Entity
    @RequestMapping(value = "/movies/{id}", method = RequestMethod.GET)
    public ResponseEntity<Movie> getMovie(@PathVariable(value = "id") Long movieId) {
        this.movieService.getMovie(movieId);// (2)
        return new ResponseEntity(this.movieRepository.findById(movieId), HttpStatus.FOUND);
    }


    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        this.movieService.addMovie(movie);
        return new ResponseEntity(movie, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/movies/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Movie> updateMovie(@PathVariable(value = "id") Long movieId, @RequestBody Movie movie) {
        Optional<Movie> optMovie = movieRepository.findById(movieId);
        if (optMovie.isPresent()) {
            movieService.updateMovie(movie,movieId);
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(value = "/movies/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Movie> deleteMovie(@PathVariable("id") Long movieId) {
        Optional<Movie> optMovie = movieRepository.findById(movieId);
        if (optMovie.isPresent()) {
            movieService.deleteMovie(movieId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}