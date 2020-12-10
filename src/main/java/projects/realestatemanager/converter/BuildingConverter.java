package projects.realestatemanager.converter;

import org.springframework.stereotype.Component;
import projects.realestatemanager.data.BuildingSummary;
import projects.realestatemanager.domain.model.Building;

import java.time.LocalDate;
import java.util.Date;

@Component
public class BuildingConverter {

    public BuildingSummary toBuildingSummary(Building building) {
        return BuildingSummary.builder()
                .region(building.getRegion())
                .isActive(building.isActive())
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
                .isParkingAvailable(building.isParkingAvailable())
                .buildingConstructionType(building.getBuildingConstructionType())
                .developerName(building.getDeveloper().getDeveloperName())
                .developerContact(building.getDeveloper().getDeveloperContactNumber())
                .isElevatorAvailable(building.isElevatorAvailable())
                .isPrimaryMarket(building.isPrimaryMarket())
                .buildingSection(building.getBuildingSection())
                .buildingRealizationTerm(building.getBuildingRealizationTerm())
                .isBuildingFinished(building.getBuildingRealizationTerm().isBefore(LocalDate.now()))
                .isConnectedToMedia(building.isConnectedToMedia())
                .photosUrl(building.getPhotosUrl())
                .creationDate(building.getCreationDate())
                .numberOfApartments(building.getApartments().size())
                .build();
    }
}
