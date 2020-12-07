package projects.realestatemanager.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.realestatemanager.domain.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;
}
