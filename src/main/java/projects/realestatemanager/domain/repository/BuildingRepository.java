package projects.realestatemanager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projects.realestatemanager.domain.model.Building;

import java.lang.annotation.Native;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public interface BuildingRepository extends JpaRepository<Building, Long> {

    boolean existsByCityAndStreetAndBuildingNumber(String city, String street, String buildingNumber);

    List<Building> findAllByStreet(String street);

    List<Building> findAllByDeveloperIdAndIsActive(Long developerId, boolean b);


    List<Building> findAllByDeveloperId(Long id);
    @Query("SELECT b FROM Building b WHERE b.isConnectedToMedia=?1")
    List<Building> findAllByConnectedToMedia(Boolean isConnectedToMedia);

    @Query("SELECT b FROM Building b WHERE b.buildingRealizationTerm>=?1")
    List<Building> findAllMinRealizationTerm(LocalDate minBuildingRealizationTerm);

    @Query("SELECT b FROM Building b WHERE b.buildingRealizationTerm<=?1")
    List<Building> findAllMaxRealizationTerm(LocalDate maxBuildingRealizationTerm);

    @Query(
            value = "SELECT * FROM buildings b INNER JOIN users_favourite_buildings f ON b.id = f.building_id WHERE f.user_id = ?1",
            nativeQuery = true)
    List<Building> getUsersFavouriteBuildings(Long userId);


//    @Query("select count(a) from Building b join Apartment a where b.id = ?1")
//    int isConnectedWithApartment(Long id);
}
