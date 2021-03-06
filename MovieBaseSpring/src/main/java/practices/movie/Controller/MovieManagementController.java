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

@RequestMapping("movies")
@RestController
@CrossOrigin(origins = "*")
public class MovieManagementController {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieService movieService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        this.movieService.addMovie(movie);
        System.out.println("addMovie done");
        return new ResponseEntity(movie, HttpStatus.CREATED);
    }


    @PutMapping(path = "{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Movie> updateMovie(@PathVariable(value = "id") Long movieId,
                                             @RequestBody Movie movie) {

//        Logika do serwisu, nie odwoływać się do repo
        Optional<Movie> optMovie = movieRepository.findById(movieId);
        if (optMovie.isPresent()) {
            movieService.updateMovie(movie,movieId);
            System.out.println("updateMovie done");
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

// /{id}
    @DeleteMapping(path = "{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Movie> deleteMovie(@PathVariable("id") Long movieId) {

//        Logika do serwisu
        Optional<Movie> optMovie = movieRepository.findById(movieId);
        if (optMovie.isPresent()) {
            movieService.deleteMovie(movieId);
            System.out.println("deleteMovie done");
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}