package projects.realestatemanager.data.building;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BuildingSummary {
    private String region;

    private Boolean isActive;

    private String city;

    private String district;

    private String street;

    private String buildingNumber;

    private String buildingDetails; //todo rozwijane okienko w buildings/list

    private Integer distanceToKindergarten;

    private Integer distanceToSchool;

    private Integer distanceToShoppingCenters;

    private Integer distanceToPark;

    private Integer distanceToRiver;

    private Integer timeToCityCenterMin;

    private Integer timeToBusStopMin;

    private String buildingLocationDetails;//todo rozwijane okienko w buildings/list

    private Boolean isParkingAvailable;

    private Boolean isGarageAvailable;

    private Boolean isElevatorAvailable;

    private String buildingConstructionType;

    private String developerName;//todo rozwijana lista developera, link do developera w buildings/list,

    private Boolean isPrimaryMarket;

    private Integer numberOfApartments;

    private Integer buildingSection;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate buildingRealizationTerm;

    private Boolean isBuildingFinished;

    private Boolean isConnectedToMedia;

    private String photosUrl;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate creationDate;


}
