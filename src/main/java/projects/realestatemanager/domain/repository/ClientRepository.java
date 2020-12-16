package projects.realestatemanager.domain.repository;

import org.hibernate.type.TrueFalseType;
import org.springframework.data.jpa.repository.JpaRepository;
import projects.realestatemanager.domain.model.Client;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    boolean existsByClientContactEmail(String clientName);

    List<Client> findByFavourite(Boolean favourite);
}
