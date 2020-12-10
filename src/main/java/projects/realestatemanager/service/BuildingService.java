package projects.realestatemanager.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projects.realestatemanager.converter.BuildingConverter;
import projects.realestatemanager.data.BuildingSummary;
import projects.realestatemanager.domain.model.Building;
import projects.realestatemanager.domain.repository.BuildingRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class BuildingService {

    private final BuildingRepository buildingRepository;
    private final BuildingConverter buildingConverter;

    public List<BuildingSummary> findAllBuildings(){
        log.debug("Getting all buildings info");

        return buildingRepository.findAll().stream()
                .map(buildingConverter::toBuildingSummary)
                .collect(Collectors.toList());
    }


}
