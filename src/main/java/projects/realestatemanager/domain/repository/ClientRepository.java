package projects.realestatemanager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projects.realestatemanager.domain.model.Client;


import java.util.Arrays;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {



}
