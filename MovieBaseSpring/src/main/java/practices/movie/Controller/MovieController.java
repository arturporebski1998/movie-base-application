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
public class MovieController {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieService movieService;

    public MovieController(MovieRepository movieRepository, MovieService movieService) {
        this.movieRepository = movieRepository;
        this.movieService = movieService;
    }

    @GetMapping(value = "/movies")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Movie> getMovies() {
        return new ResponseEntity(this.movieRepository.findAll(), HttpStatus.OK);
    }


    @GetMapping(value = "/movies/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Movie> getMovie(@PathVariable(value = "id") Long movieId) {
        return new ResponseEntity(this.movieRepository.findById(movieId), HttpStatus.OK);
    }

}