package practices.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practices.movie.model.Movie;
import practices.movie.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

//     Przez konstruktor
    @Autowired
    MovieRepository movieRepository;

    @Override
    public void getMovies() {
        this.movieRepository.findAll();
    }

    @Override
    public void getMovie(Long id) {
        this.movieRepository.findById(id);
    }

    @Override
    public void addMovie(Movie movie) {
        this.movieRepository.save(movie);
    }

//   Nie prościej przesłać cały obiekt z id?
    @Override
    public void updateMovie(Movie movie, Long id) {
        movie.setId(id);
        this.movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Long id) {
        this.movieRepository.deleteById(id);
    }
}
