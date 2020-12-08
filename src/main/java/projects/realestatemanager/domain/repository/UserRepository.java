package projects.realestatemanager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.realestatemanager.domain.model.User;

import java.util.Arrays;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);

}
