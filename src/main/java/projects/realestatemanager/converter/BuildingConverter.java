package projects.realestatemanager.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import projects.realestatemanager.data.building.BuildingSummary;
import projects.realestatemanager.domain.model.Building;
import projects.realestatemanager.domain.repository.DeveloperRepository;
import projects.realestatemanager.web.command.CreateBuildingCommand;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class BuildingConverter {

    private final DeveloperRepository developerRepository;

    public BuildingSummary toBuildingSummary(Building building) {
        return BuildingSummary.builder()
                .region(building.getRegion())
                .isActive(building.getIsActive())
                .city(building.getCity())
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
                .buildingConstructionType(building.getBuildingConstructionType())
                .developerName(building.getDeveloper().getDeveloperName())
                .developerContact(building.getDeveloper().getDeveloperContactNumber())
                .isElevatorAvailable(building.getIsElevatorAvailable())
                .isPrimaryMarket(building.getIsPrimaryMarket())
                .buildingSection(building.getBuildingSection())
                .buildingRealizationTerm(building.getBuildingRealizationTerm())
                .isBuildingFinished(building.getBuildingRealizationTerm().isBefore(LocalDate.now()))
                .isConnectedToMedia(building.getIsConnectedToMedia())
                .photosUrl(building.getPhotosUrl())
                .creationDate(building.getCreationDate())
                .numberOfApartments(building.getApartments().size())
                .build();
    }

    public Building from(CreateBuildingCommand createBuildingCommand) {
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
                .developer(developerRepository.getById(createBuildingCommand.getDeveloperId()))
                .isElevatorAvailable(createBuildingCommand.getElevatorAvailable())
                .isPrimaryMarket(createBuildingCommand.getPrimaryMarket())
                .buildingSection(createBuildingCommand.getBuildingSection())
                .buildingRealizationTerm(createBuildingCommand.getBuildingRealizationTerm())
                .isConnectedToMedia(createBuildingCommand.getConnectedToMedia())
                .photosUrl(createBuildingCommand.getPhotosUrl())
                .build();
    }
}



















