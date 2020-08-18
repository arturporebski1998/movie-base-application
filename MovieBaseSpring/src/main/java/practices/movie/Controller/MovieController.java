package practices.movie.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practices.movie.Model.Movie;
import practices.movie.Repository.MovieRepository;

import java.util.LinkedList;
import java.util.Optional;


// Użycie adnotacji @GetMapping/post etc a nad klasą dać @RequestMapping wspólny dla wszystkich
// Controller -> Service -> ServiceImpl -> Repository !!!!!!!!
// duża część komenatrzy jest zbędna, większość metod mówi sama za siebie
@RestController
@CrossOrigin(origins = "*")
public class MovieController {

//     Przez konstruktor ps. final
    @Autowired
    private MovieRepository movieRepository;

    //get movies
    @RequestMapping(value = "/movies", method = RequestMethod.GET)
//    LinkedList? Doczytaj o ResponeEntity
    public ResponseEntity<LinkedList<Movie>> getAllMovies() {
        return new ResponseEntity(this.movieRepository.findAll(), HttpStatus.OK);
    }

    //get movie by id
    @RequestMapping(value = "/movies/{id}", method = RequestMethod.GET)
    public ResponseEntity<Movie> getOneMovie(@PathVariable(value = "id") Long movieId) {
        return new ResponseEntity(this.movieRepository.findById(movieId), HttpStatus.OK);
    }

    //save movie
    // make sure the movie that arrives does not have an Id
    // otherwise you will update existing record
    /// done - it does not have id
    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        return new ResponseEntity<>(this.movieRepository.save(movie), HttpStatus.OK);
    }

    // update movie
    //make sure that movie has the same id as the movieId or remove movieId from endpoint. Put tells us it is an update, so we know that movie has ID
    ///done - value od id not changing
    @RequestMapping(value = "/movies/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Movie> updateMovie(@PathVariable(value = "id") Long movieId, @RequestBody Movie movie) {
        Optional<Movie> optMovie = movieRepository.findById(movieId);
        if (optMovie.isPresent()) {
            movie.setId(movieId);
            return new ResponseEntity<>(this.movieRepository.save(movie), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //delete movie
    @RequestMapping(value = "/movies/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Movie> deleteMovie(@PathVariable("id") Long movieId) {
        Optional<Movie> optMovie = movieRepository.findById(movieId);
        if (optMovie.isPresent()) {
            movieRepository.deleteById(movieId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}