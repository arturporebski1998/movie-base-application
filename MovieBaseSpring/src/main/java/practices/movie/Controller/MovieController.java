package practices.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import practices.movie.model.Movie;
import practices.movie.repository.MovieRepository;
import practices.movie.service.MovieService;



// /api/movies - łatwiej zabezpieczyć
@RequestMapping("movies")
@RestController
// Masz security więc co to tu robi
@CrossOrigin(origins = "*")
public class MovieController {

//    Wstrzykujesz przed kontruktor więc po co to?
    @Autowired
    MovieRepository movieRepository;


    @Autowired
    //        private final - enkapsulacja danych
    MovieService movieService;

    public MovieController(MovieRepository movieRepository,
                           MovieService movieService) {
        this.movieRepository = movieRepository;
        this.movieService = movieService;
    }

    @GetMapping
//    SecurityConfig ;)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<Movie> getMovies() {
        //        system out print?
        System.out.println("getMovies done");
// czemu tu jest odwołanie do repository?
        return new ResponseEntity(this.movieRepository.findAll(), HttpStatus.OK);
    }


    @GetMapping(path = "{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<Movie> getMovie(@PathVariable(value = "id") Long movieId) {
//        system out print?
        System.out.println("getMovie done");
        // czemu tu jest odwołanie do repository?
        return new ResponseEntity(this.movieRepository.findById(movieId), HttpStatus.OK);
    }

}