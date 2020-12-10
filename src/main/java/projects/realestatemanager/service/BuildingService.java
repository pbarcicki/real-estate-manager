package projects.realestatemanager.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projects.realestatemanager.converter.BuildingConverter;
import projects.realestatemanager.data.BuildingSummary;
import projects.realestatemanager.domain.model.Building;
import projects.realestatemanager.domain.repository.BuildingRepository;
import projects.realestatemanager.exception.BuildingAlreadyExistsException;
import projects.realestatemanager.web.command.CreateBuildingCommand;

import java.time.LocalDate;
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


    public void add(CreateBuildingCommand createBuildingCommand) {
        log.debug("Building data to be saved: {}", createBuildingCommand);

        Building buildingToAdd = buildingConverter.from(createBuildingCommand);
        log.debug("Converted building entity to add: {}", buildingToAdd);
        if (buildingRepository.existsByCityAndStreetAndBuildingNumber(buildingToAdd.getCity(), buildingToAdd.getStreet(), buildingToAdd.getBuildingNumber())) {
            log.debug("Tried to add existing building");
            //todo exception
            throw new BuildingAlreadyExistsException(String.format("Building in %s on $s street, number %s already exists in DB", buildingToAdd.getCity(), buildingToAdd.getStreet(), buildingToAdd.getBuildingNumber()));
        }

        buildingToAdd.setActive(true);
        buildingToAdd.setCreationDate(LocalDate.now());
        buildingRepository.save(buildingToAdd);
        log.debug("Added building: {}", buildingToAdd);

    }
}
