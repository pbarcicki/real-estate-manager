package projects.realestatemanager.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projects.realestatemanager.converter.BuildingConverter;
import projects.realestatemanager.data.building.BuildingSummary;
import projects.realestatemanager.domain.model.Building;
import projects.realestatemanager.domain.repository.BuildingRepository;
import projects.realestatemanager.exception.BuildingAlreadyExistsException;
import projects.realestatemanager.exception.EntityDoesNotExistException;
import projects.realestatemanager.web.command.CreateBuildingCommand;
import projects.realestatemanager.web.command.EditBuildingCommand;

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
                .map(buildingConverter::from)
                .collect(Collectors.toList());
    }


    public void add(CreateBuildingCommand createBuildingCommand) {
        log.debug("Building data to be saved: {}", createBuildingCommand);

        Building buildingToAdd = buildingConverter.from(createBuildingCommand);
        log.debug("Converted building entity to add: {}", buildingToAdd);

        if (buildingRepository.existsByCityAndStreetAndBuildingNumber(buildingToAdd.getCity(), buildingToAdd.getStreet(), buildingToAdd.getBuildingNumber())) {
            log.debug("Tried to add existing building");
            throw new BuildingAlreadyExistsException(String.format("Building in %s on $s street, number %s already exists in DB", buildingToAdd.getCity(), buildingToAdd.getStreet(), buildingToAdd.getBuildingNumber()));
        }

        buildingToAdd.setIsActive(true);
        buildingToAdd.setCreationDate(LocalDate.now());
        buildingRepository.save(buildingToAdd);
        log.debug("Added building: {}", buildingToAdd);
    }



    public BuildingSummary showBuildingById(Long id) {
        log.debug("Building id to find in DB: {}", id);

        Building buildingToEdit = buildingRepository.getOne(id);
        log.debug("Received building to edit: {}", buildingToEdit);

        if (!buildingRepository.existsById(id)) {
            log.debug("Tried to edit non-existing building!");
            throw new EntityDoesNotExistException(String.format("Building with id %s does not exist!", id));
        }

        return buildingConverter.from(buildingToEdit);

    }
    //todo
    public boolean editBuilding(EditBuildingCommand editBuildingCommand) {
        Long id = editBuildingCommand.getId();

        if (!buildingRepository.existsById(id)) {
            log.debug("Tried to edit non-existing building!");
            throw new EntityDoesNotExistException(String.format("Building with id %s does not exist!", id));
        }

        Building buildingToEdit = buildingRepository.getOne(id);
        log.debug("Building to edit: {}", buildingToEdit);
        buildingToEdit = buildingConverter.from(editBuildingCommand, buildingToEdit);

        log.debug("Building modified: {}", buildingToEdit);
        return true;
    }
}
