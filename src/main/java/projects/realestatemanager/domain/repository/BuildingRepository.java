package projects.realestatemanager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projects.realestatemanager.domain.model.Building;

import java.lang.annotation.Native;
import java.util.Arrays;
import java.util.List;

public interface BuildingRepository extends JpaRepository<Building, Long> {

    boolean existsByCityAndStreetAndBuildingNumber(String city, String street, String buildingNumber);

    Building findByDeveloperId(Long developerId);

    List<Building> findAllByStreet(String street);

    List<Building> findAllByDeveloperId(Long developerId);


//    @Query("select count(a) from Building b join Apartment a where b.id = ?1")
//    int isConnectedWithApartment(Long id);
}
