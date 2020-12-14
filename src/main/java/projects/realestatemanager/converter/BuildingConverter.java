package projects.realestatemanager.converter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import projects.realestatemanager.data.building.BuildingSummary;
import projects.realestatemanager.domain.model.Building;
import projects.realestatemanager.domain.model.Developer;
import projects.realestatemanager.domain.repository.DeveloperRepository;
import projects.realestatemanager.web.command.CreateBuildingCommand;
import projects.realestatemanager.web.command.EditBuildingCommand;

import java.time.LocalDate;

@Slf4j
@Component
@RequiredArgsConstructor
public class BuildingConverter {

    private final DeveloperRepository developerRepository;

    public BuildingSummary from(Building building) {
        return BuildingSummary.builder()
                .id(building.getId())
                .region(building.getRegion())
                .isActive(building.getIsActive())
                .city(building.getCity())
                .district((building.getDistrict()))
                .street(building.getStreet())
                .buildingNumber(building.getBuildingNumber())
                .buildingDetails(building.getBuildingDetails())
                .distanceToKindergarten(building.getDistanceToKindergarten())
                .distanceToSchool(building.getDistanceToSchool())
                .distanceToShoppingCenters(building.getDistanceToShoppingCenters())
                .distanceToPark(building.getDistanceToPark())
                .distanceToRiver(building.getDistanceToRiver())
                .timeToCityCenterMin(building.getTimeToCityCenterMin())
                .timeToBusStopMin(building.getTimeToBusStopMin())
                .buildingLocationDetails(building.getBuildingLocationDetails())
                .isParkingAvailable(building.getIsParkingAvailable())
                .isGarageAvailable(building.getIsGarageAvailable())
                .buildingConstructionType(building.getBuildingConstructionType())
                .developerName(building.getDeveloperName())
                .isElevatorAvailable(building.getIsElevatorAvailable())
                .isPrimaryMarket(building.getIsPrimaryMarket())
                .numberOfApartments(building.getNumberOfApartments())
                .buildingSection(building.getBuildingSection())
                .buildingRealizationTerm(building.getBuildingRealizationTerm())
                .isBuildingFinished(building.getBuildingRealizationTerm().isBefore(LocalDate.now()))
                .isConnectedToMedia(building.getIsConnectedToMedia())
                .photosUrl(building.getPhotosUrl())
                .creationDate(building.getCreationDate())
                .numberOfApartments(building.getApartments().size())
                .build();
    }


    public Building from(CreateBuildingCommand createBuildingCommand, Developer developer) {
        return Building.builder()
                .region(createBuildingCommand.getRegion())
                .city(createBuildingCommand.getCity())
                .district(createBuildingCommand.getDistrict())
                .street(createBuildingCommand.getStreet())
                .buildingNumber(createBuildingCommand.getBuildingNumber())
                .buildingDetails(createBuildingCommand.getBuildingDetails())
                .distanceToKindergarten(createBuildingCommand.getDistanceToKindergarten())
                .distanceToSchool(createBuildingCommand.getDistanceToSchool())
                .distanceToShoppingCenters(createBuildingCommand.getDistanceToShoppingCenters())
                .distanceToPark(createBuildingCommand.getDistanceToPark())
                .distanceToRiver(createBuildingCommand.getDistanceToRiver())
                .timeToCityCenterMin(createBuildingCommand.getTimeToCityCenterMin())
                .timeToBusStopMin(createBuildingCommand.getTimeToBusStopMin())
                .buildingLocationDetails(createBuildingCommand.getBuildingLocationDetails())
                .isParkingAvailable(createBuildingCommand.getParkLot())
                .isGarageAvailable(createBuildingCommand.getGarageAvailable())
                .buildingConstructionType(createBuildingCommand.getBuildingConstructionType())
                .developer(developer)
                .isElevatorAvailable(createBuildingCommand.getElevatorAvailable())
                .isPrimaryMarket(createBuildingCommand.getPrimaryMarket())
                .numberOfApartments(createBuildingCommand.getNumberOfApartments())
                .buildingSection(createBuildingCommand.getBuildingSection())
                .buildingRealizationTerm(createBuildingCommand.getBuildingRealizationTerm())
                .isConnectedToMedia(createBuildingCommand.getConnectedToMedia())
                .photosUrl(createBuildingCommand.getPhotosUrl())
                .build();
    }

    public Building from(EditBuildingCommand editBuildingCommand, Building building, Developer developer) {
                building.setEditDate(LocalDate.now());
                building.setIsActive(editBuildingCommand.getIsActive());
                building.setRegion(editBuildingCommand.getRegion());
                building.setCity(editBuildingCommand.getCity());
                building.setDistrict(editBuildingCommand.getDistrict());
                building.setStreet(editBuildingCommand.getStreet());
                building.setBuildingNumber(editBuildingCommand.getBuildingNumber());
                building.setBuildingDetails(editBuildingCommand.getBuildingDetails());
                building.setDistanceToKindergarten(editBuildingCommand.getDistanceToKindergarten());
                building.setDistanceToSchool(editBuildingCommand.getDistanceToSchool());
                building.setDistanceToShoppingCenters(editBuildingCommand.getDistanceToShoppingCenters());
                building.setDistanceToPark(editBuildingCommand.getDistanceToPark());
                building.setDistanceToRiver(editBuildingCommand.getDistanceToRiver());
                building.setTimeToCityCenterMin(editBuildingCommand.getTimeToCityCenterMin());
                building.setTimeToBusStopMin(editBuildingCommand.getTimeToBusStopMin());
                building.setBuildingLocationDetails(editBuildingCommand.getBuildingLocationDetails());
                building.setIsParkingAvailable(editBuildingCommand.getParkLot());
                building.setIsGarageAvailable(editBuildingCommand.getGarageAvailable());
                building.setIsElevatorAvailable(editBuildingCommand.getElevatorAvailable());
                building.setIsConnectedToMedia(editBuildingCommand.getConnectedToMedia());
                building.setBuildingConstructionType(editBuildingCommand.getBuildingConstructionType());
                building.setDeveloper(developer);
                building.setIsPrimaryMarket(editBuildingCommand.getPrimaryMarket());
                building.setNumberOfApartments(editBuildingCommand.getNumberOfApartments());
                building.setBuildingSection(editBuildingCommand.getBuildingSection());
                building.setBuildingRealizationTerm(editBuildingCommand.getBuildingRealizationTerm());
                building.setPhotosUrl(editBuildingCommand.getPhotosUrl());
            return building;
    }
}



















