package practices.movie.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practices.movie.Model.Movie;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
