package projects.realestatemanager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.realestatemanager.domain.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUserEmail(String userEmail);

    Optional<User> findByUsername(String username);
}
