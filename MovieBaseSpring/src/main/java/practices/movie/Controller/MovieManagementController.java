package practices.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import practices.movie.model.Movie;
import practices.movie.repository.MovieRepository;
import practices.movie.service.MovieService;

import java.util.Optional;

@RequestMapping
@RestController
@CrossOrigin(origins = "*")
public class MovieManagementController {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieService movieService;

    @PostMapping(value = "/management/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        this.movieService.addMovie(movie);
        return new ResponseEntity(movie, HttpStatus.CREATED);
    }


    @PutMapping(value = "/management/movies/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Movie> updateMovie(@PathVariable(value = "id") Long movieId, @RequestBody Movie movie) {
        Optional<Movie> optMovie = movieRepository.findById(movieId);
        if (optMovie.isPresent()) {
            movieService.updateMovie(movie,movieId);
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping(value = "/management/movies/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
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
