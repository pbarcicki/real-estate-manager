package projects.realestatemanager.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.realestatemanager.domain.repository.BuildingRepository;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository repository;
}
