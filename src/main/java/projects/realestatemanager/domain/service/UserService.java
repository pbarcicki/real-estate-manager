package projects.realestatemanager.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.realestatemanager.domain.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

}
