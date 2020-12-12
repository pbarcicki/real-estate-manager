package projects.realestatemanager.web.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import projects.realestatemanager.domain.model.Developer;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class CreateBuildingCommand {

    @NotBlank
    @Size(min=3, max = 26)
    private String region;

    @NotBlank
    @Size(min=3, max = 26)
    private String city;

    @NotBlank
    @Size(min=3, max = 26)
    private String district;

    @NotBlank
    @Size(min=3, max = 26)
    private String street;

    @NotBlank
    @Digits(integer = 4, fraction = 0)
    private String buildingNumber;

    @Size(max = 120)
    private String buildingDetails;

    @Digits(integer = 4, fraction = 0)
    private Integer distanceToKindergarten;

    @Digits(integer = 4, fraction = 0)
    private Integer distanceToSchool;

    @Digits(integer = 4, fraction = 0)
    private Integer distanceToShoppingCenters;

    //@NotBlank
    @Digits(integer = 4, fraction = 0)
    private Integer distanceToPark;

    @Digits(integer = 4, fraction = 0)
    private Integer distanceToRiver;

    @Digits(integer = 4, fraction = 0)
    private Integer timeToCityCenterMin;

    @Digits(integer = 3, fraction = 0)
    private Integer timeToBusStopMin;

    @Size(max = 120)
    private String buildingLocationDetails;

    //return Boolean.valueOf(booleanField);
    @NotNull
    private boolean parkLot;

    @NotNull
    private boolean garageAvailable;

    @NotBlank
    @Size(min=3, max = 15)
    private String buildingConstructionType;

    @NotNull
    private Long developerId;

    @NotNull
    private boolean elevatorAvailable;

    @NotNull
    private boolean primaryMarket;

    @Digits(fraction = 0, integer = 20)
    private Integer buildingSection;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate buildingRealizationTerm;

    @NotNull
    private boolean connectedToMedia;

    @NotBlank
    @URL
    private String photosUrl;

}
