package projects.realestatemanager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.realestatemanager.domain.model.Apartment;

public interface ApartmentRepository extends JpaRepository <Apartment, Long> {

     boolean existsById(Long id);
}
