package practices.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import practices.movie.model.Movie;
import practices.movie.repository.MovieRepository;
import practices.movie.service.MovieService;



@RequestMapping("movies")
@RestController
@CrossOrigin(origins = "*")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieService movieService;

    public MovieController(MovieRepository movieRepository,
                           MovieService movieService) {
        this.movieRepository = movieRepository;
        this.movieService = movieService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<Movie> getMovies() {
        System.out.println("getMovies done");
        return new ResponseEntity(this.movieRepository.findAll(), HttpStatus.OK);
    }


    @GetMapping(path = "{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<Movie> getMovie(@PathVariable(value = "id") Long movieId) {
        System.out.println("getMovie done");
        return new ResponseEntity(this.movieRepository.findById(movieId), HttpStatus.OK);
    }

}