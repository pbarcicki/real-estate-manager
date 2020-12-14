package projects.realestatemanager.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projects.realestatemanager.converter.BuildingConverter;
import projects.realestatemanager.data.building.BuildingSummary;
import projects.realestatemanager.domain.model.Building;
import projects.realestatemanager.domain.model.Developer;
import projects.realestatemanager.domain.repository.BuildingRepository;
import projects.realestatemanager.domain.repository.DeveloperRepository;
import projects.realestatemanager.exception.BuildingAlreadyExistsException;
import projects.realestatemanager.exception.EntityDoesNotExistException;
import projects.realestatemanager.exception.EntityHasConnectionsException;
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
    private final DeveloperRepository developerRepository;
    private final BuildingConverter buildingConverter;

    public List<BuildingSummary> findAllBuildings(){
        log.debug("Getting all buildings info");

        return buildingRepository.findAll().stream()
                .map(buildingConverter::from)
                .collect(Collectors.toList());
    }


    public void add(CreateBuildingCommand createBuildingCommand) {
        log.debug("Building data to be saved: {}", createBuildingCommand);
        Developer developerConnection = developerRepository.getOne(createBuildingCommand.getDeveloperId());
        Building buildingToAdd = buildingConverter.from(createBuildingCommand, developerConnection);
        log.debug("Converted building entity to add: {}", buildingToAdd);

        if (buildingRepository.existsByCityAndStreetAndBuildingNumber(buildingToAdd.getCity(), buildingToAdd.getStreet(), buildingToAdd.getBuildingNumber())) {
            log.debug("Tried to add existing building");
            throw new BuildingAlreadyExistsException(String.format("Building in %s on $s street, number %s already exists in DB", buildingToAdd.getCity(), buildingToAdd.getStreet(), buildingToAdd.getBuildingNumber()));
        }

        if (!developerRepository.existsById(createBuildingCommand.getDeveloperId())) {
            throw new EntityDoesNotExistException(String.format("Developer with id %s does not exist", createBuildingCommand.getDeveloperId()));
        }

        buildingToAdd.setIsActive(true);
        buildingToAdd.setCreationDate(LocalDate.now());
        buildingToAdd.setDeveloperName(buildingToAdd.getDeveloper().getDeveloperName());
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
        Developer developerConnection = developerRepository.getOne(editBuildingCommand.getDeveloperId());

        if (!buildingRepository.existsById(id)) {
            log.debug("Tried to edit non-existing building!");
            throw new EntityDoesNotExistException(String.format("Building with id %s does not exist!", id));
        }

        if (!developerRepository.existsById(editBuildingCommand.getDeveloperId())) {
            throw new EntityDoesNotExistException(String.format("Developer with id %s does not exist", editBuildingCommand.getDeveloperId()));
        }

        Building buildingToEdit = buildingRepository.getOne(id);
        log.debug("Building to edit: {}", buildingToEdit);
        buildingToEdit = buildingConverter.from(editBuildingCommand, buildingToEdit, developerConnection);

        log.debug("Building modified: {}", buildingToEdit);
        return true;
    }

    public boolean deleteById(Long id) {
        log.debug("Building to delete: {}", buildingRepository.getOne(id));

        if (!buildingRepository.existsById(id)) {
            log.debug("Tried to delete non-existing building!");
            throw new EntityDoesNotExistException(String.format("Building with id %s does not exist!", id));
        }
//        if (buildingRepository.isConnectedWithApartment(id)>0) {
        if (false){
            log.debug("Tried to delete building which has apartments!");
            throw new EntityHasConnectionsException("Building has connected apartments!");
        }
        buildingRepository.deleteById(id);
        log.debug("Deleted building with id: {}", id);
        return true;
    }
}
