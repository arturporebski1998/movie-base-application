package practices.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practices.registration.model.ERole;
import practices.registration.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}