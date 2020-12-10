package projects.realestatemanager.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import projects.realestatemanager.domain.model.Apartment;
import projects.realestatemanager.domain.model.Developer;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BuildingSummary {
    private String region;

    private String city;

    private String district;

    private String street;

    private String buildingNumber;

    private String buildingDetails;

    private Integer distanceToKindergarten;

    private Integer distanceToSchool;

    private Integer distanceToShoppingCenters;

    private Integer distanceToPark;

    private Integer distanceToRiver;

    private Integer timeToCityCenterMin;

    private Integer timeToBusStopMin;

    private String buildingLocationDetails;

    private boolean isParkingAvailable;

    private boolean isGarageAvailable;

    private String buildingConstructionType;

    private String developerName;

    private String developerContact;

    private boolean isElevatorAvailable;

    private boolean isPrimaryMarket;

    private Integer buildingSection;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate buildingRealizationTerm;

    private boolean isBuildingFinished;

    private boolean isConnectedToMedia;

    private String photosUrl;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate creationDate;

    private Integer numberOfApartments;
}
