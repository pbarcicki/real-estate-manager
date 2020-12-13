package projects.realestatemanager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projects.realestatemanager.domain.model.Apartment;

public interface ApartmentRepository<id> extends JpaRepository <Apartment, Long> {

     boolean existsById(Long id);
}
