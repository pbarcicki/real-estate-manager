package projects.realestatemanager.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.realestatemanager.domain.repository.ApartmentRepository;

@Service
public class ApartmentService {

@Autowired
    private ApartmentRepository repository;
}
