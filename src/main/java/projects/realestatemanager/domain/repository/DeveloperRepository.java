package projects.realestatemanager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.realestatemanager.domain.model.Developer;

import java.util.Optional;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    boolean existsByDeveloperName(String developerName);

    Optional<Developer> findByDeveloperName(String developerName);

    //Optional<Developer> findById(Long id);
}