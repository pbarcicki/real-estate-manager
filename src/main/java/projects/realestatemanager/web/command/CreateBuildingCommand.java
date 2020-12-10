package projects.realestatemanager.web.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;
import projects.realestatemanager.domain.model.Developer;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
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


    private String buildingDetails;

    @NotBlank
    @Digits(integer = 4, fraction = 0)
    private Integer distanceToKindergarten;

    @NotBlank
    @Digits(integer = 4, fraction = 0)
    private Integer distanceToSchool;

    @NotBlank
    @Digits(integer = 4, fraction = 0)
    private Integer distanceToShoppingCenters;

    @NotBlank
    @Digits(integer = 4, fraction = 0)
    private Integer distanceToPark;

    @NotBlank
    @Digits(integer = 4, fraction = 0)
    private Integer distanceToRiver;

    @NotBlank
    @Digits(integer = 3, fraction = 0)
    private Integer timeToCityCenterMin;

    @NotBlank
    @Digits(integer = 3, fraction = 0)
    private Integer timeToBusStopMin;

    private String buildingLocationDetails;

    //return Boolean.valueOf(booleanField);
    @NotBlank
    private boolean isParkingAvailable;

    @NotBlank
    private boolean isGarageAvailable;

    @NotBlank
    @Size(min=3, max = 15)
    private String buildingConstructionType;

    @NotBlank
    private Developer developer;

    @NotBlank
    private boolean isElevatorAvailable;

    @NotBlank
    private boolean isPrimaryMarket;

    @NotBlank
    private Integer buildingSection;

    @NotBlank
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate buildingRealizationTerm;

    @NotBlank
    private boolean isConnectedToMedia;

    @NotBlank
    @URL
    private String photosUrl;

}
