package projects.realestatemanager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.realestatemanager.domain.model.Developer;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    boolean existsByDeveloperName(String developerName);

    Developer getById(Long developerId);
}