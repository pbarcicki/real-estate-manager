package projects.realestatemanager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projects.realestatemanager.domain.model.Apartment;
import projects.realestatemanager.domain.model.Building;

import java.util.List;

public interface ApartmentRepository extends JpaRepository <Apartment, Long> {

    boolean existsById(Long id);

    boolean existsByFloorAndAreaAndBuildingAndWindowsDirection(Integer floor, Integer area, Building building, String windowsDirection);

    List<Apartment> findAllByIdIn(List<Long> idList);

    boolean existsByBuildingId(Long id);

    List<Apartment> findAllByBuildingId(Long id);
}
