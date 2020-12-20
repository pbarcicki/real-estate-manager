package projects.realestatemanager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import projects.realestatemanager.domain.model.Developer;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    boolean existsByDeveloperName(String developerName);

    Developer getById(Long developerId);

//    @Query(
//            value = "SELECT count() FROM developer d join buildings b on d.id=b.developer_id where b.developer_id=?1",
//            nativeQuery = true)
//    Long developerBuildingAmount(Long id);

//    select count(*) from developer d join building b on d.id = b.developer_id where b.developer_id=1;

}