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

    @Query("SELECT b FROM Building b WHERE b.distanceToKindergarten<=?1")
    List<Building> findAllByMaxDistanceToKindergarten(Integer maxDistanceToKindergarten);

    @Query("SELECT b FROM Building b WHERE b.distanceToSchool<=?1")
    List<Building> findAllByMaxDistanceToSchool(Integer maxDistanceToSchool);

    @Query("SELECT b FROM Building b WHERE b.distanceToShoppingCenters<=?1")
    List<Building> findAllByMaxDistanceToShoppingCenters(Integer maxDistanceToShoppingCenters);

    @Query("SELECT b FROM Building b WHERE b.distanceToPark<=?1")
    List<Building> findAllByMaxDistanceToPark(Integer maxDistanceToPark);

    @Query("SELECT b FROM Building b WHERE b.isParkingAvailable=?1")
    List<Building> findAllByParking(Boolean isParkingAvailable);

    @Query("SELECT b FROM Building b WHERE b.isGarageAvailable=?1")
    List<Building> findAllByGarage(Boolean isGarageAvailable);

    @Query("SELECT b FROM Building b WHERE b.isElevatorAvailable=?1")
    List<Building> findAllByElevator(Boolean isElevatorAvailable);

    @Query("SELECT b FROM Building b WHERE b.isConnectedToMedia=?1")
    List<Building> findAllByConnectedToMedia(Boolean isConnectedToMedia);

    @Query("SELECT b FROM Building b WHERE b.buildingRealizationTerm>=?1")
    List<Building> findAllMinRealizationTerm(LocalDate minBuildingRealizationTerm);

    @Query("SELECT b FROM Building b WHERE b.buildingRealizationTerm<=?1")
    List<Building> findAllMaxRealizationTerm(LocalDate maxBuildingRealizationTerm);


//    @Query("select count(a) from Building b join Apartment a where b.id = ?1")
//    int isConnectedWithApartment(Long id);
}
