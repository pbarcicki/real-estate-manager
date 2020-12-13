package projects.realestatemanager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projects.realestatemanager.domain.model.Building;

import java.util.Arrays;
import java.util.List;

public interface BuildingRepository extends JpaRepository<Building, Long> {

    boolean existsByCityAndStreetAndBuildingNumber(String city, String street, String buildingNumber);

    @Query("SELECT COUNT(apt) FROM ")
    int isConnectedWithApartment(Long id);
}
