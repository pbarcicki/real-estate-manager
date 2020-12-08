package projects.realestatemanager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.realestatemanager.domain.model.Building;

public interface BuildingRepository extends JpaRepository<Building, Long> {

}
