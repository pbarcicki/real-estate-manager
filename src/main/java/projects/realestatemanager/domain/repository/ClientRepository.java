package projects.realestatemanager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import projects.realestatemanager.domain.model.Client;


import java.util.Arrays;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    boolean existsByClientContactEmail(String clientName);

    @Query(
            value = "SELECT * FROM clients c INNER JOIN clients_users cu ON c.id = cu.clients_id WHERE cu.users_id = ?1",
            nativeQuery = true)
    List<Client> getUsersFavouriteClients(Long userId);
}
