package projects.realestatemanager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.realestatemanager.domain.model.Building;

import java.util.List;

public interface BuildingRepository extends JpaRepository<Building, Long> {

    boolean existsByCityAndStreetAndBuildingNumber(String city, String street, String buildingNumber);


}
