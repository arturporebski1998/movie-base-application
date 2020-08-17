package practices.registration.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practices.registration.Model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}