package projects.realestatemanager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projects.realestatemanager.domain.model.Apartment;
import projects.realestatemanager.domain.model.Building;

import java.util.List;

public interface ApartmentRepository extends JpaRepository <Apartment, Long> {

    boolean existsById(Long id);

    boolean existsByFloorAndAreaAndBuildingAndWindowsDirection(Integer floor, Integer area, Building building, String windowsDirection);


    List<Apartment> findAllByBuildingId(Long id);

    List<Apartment> findAllByIdIn(List<Long> idList);

    @Query("SELECT a.id FROM Apartment a WHERE a.floor>=?1")
    List<Long> findAllByMinFloor(Integer minFloor);

    @Query("SELECT a.id FROM Apartment a WHERE a.floor<=?1")
    List<Long> findAllByMaxFloor(Integer minFloor);

    @Query("SELECT a.id FROM Apartment a WHERE a.area>=?1")
    List<Long> findAllByMinArea(Integer minArea);

    @Query("SELECT a.id FROM Apartment a WHERE a.area<=?1")
    List<Long> findAllByMaxArea(Integer maxArea);

    @Query("SELECT a.id FROM Apartment a WHERE a.roomsNumber>=?1")
    List<Long> findAllByMinRooms(Integer minRoomsNumber);

    @Query("SELECT a.id FROM Apartment a WHERE a.roomsNumber<=?1")
    List<Long> findAllByMaxRooms(Integer maxRoomsNumber);

    @Query("SELECT a.id FROM Apartment a WHERE a.typeOfKitchen=?1")
    List<Long> findAllByTypeOfKitchen(String typeOfKitchen);

    @Query("SELECT a.id FROM Apartment a WHERE a.price>=?1")
    List<Long> findAllByMinPrice(Integer minPrice);

    @Query("SELECT a.id FROM Apartment a WHERE a.price<=?1")
    List<Long> findAllByMaxPrice(Integer maxPrice);

    @Query("SELECT a.id FROM Apartment a WHERE a.pricePerSquareMeter>=?1")
    List<Long> findAllByMinPricePerM(Integer minPricePerSquareMeter);

    @Query("SELECT a.id FROM Apartment a WHERE a.marketType=?1")
    List<Long> findAllByMarketType(String marketType);

    @Query("SELECT a.id FROM Apartment a WHERE a.windowsDirection=?1")
    List<Long> findAllByWindowsDirection(String windowsDirection);

    @Query("SELECT a.id FROM Apartment a WHERE a.view=?1")
    List<Long> findAllByView(String view);

    @Query("SELECT a.id FROM Apartment a WHERE a.status=?1")
    List<Long> findAllByStatus(String status);

    @Query("SELECT a.id FROM Apartment a WHERE a.exclusivity=?1")
    List<Long> findAllByExclusivity(Boolean exclusivity);

    @Query("SELECT a.id FROM Apartment a WHERE a.storageRoom=?1")
    List<Long> findAllByStorageRoom(Boolean storageRoom);

    @Query("SELECT a.id FROM Apartment a WHERE a.id IN ?1 AND a.active=true")
    List<Long> findAllByActive(List<Long> apartmentsId);

    boolean existsByBuildingId(Long id);
}
