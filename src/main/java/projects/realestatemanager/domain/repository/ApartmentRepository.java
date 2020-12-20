package projects.realestatemanager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projects.realestatemanager.domain.model.Apartment;
import projects.realestatemanager.domain.model.Building;
import projects.realestatemanager.domain.model.Client;

import java.util.List;

public interface ApartmentRepository extends JpaRepository <Apartment, Long> {

    boolean existsById(Long id);

    boolean existsByFloorAndAreaAndBuildingAndWindowsDirection(Integer floor, Integer area, Building building, String windowsDirection);

    List<Apartment> findAllByIdIn(List<Long> idList);

    boolean existsByBuildingId(Long id);

    List<Apartment> findAllByBuildingId(Long id);

    @Query(
            value = "SELECT * FROM apartments a INNER JOIN users_favourite_apartments ufa ON a.id = ufa.apartment_id WHERE ufa.user_id = ?1",
            nativeQuery = true)
    List<Apartment> getUsersFavouriteApartments(Long userId);
}
