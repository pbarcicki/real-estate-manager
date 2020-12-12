package projects.realestatemanager.web.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EditBuildingCommand {

    private Long id;

    @NotNull
    private Boolean isActive;

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

    @NotNull
    @Digits(integer = 4, fraction = 0)
    private Integer distanceToKindergarten;

    @NotNull
    @Digits(integer = 4, fraction = 0)
    private Integer distanceToSchool;

    @NotNull
    @Digits(integer = 4, fraction = 0)
    private Integer distanceToShoppingCenters;

    @NotNull
    @Digits(integer = 4, fraction = 0)
    private Integer distanceToPark;

    @NotNull
    @Digits(integer = 4, fraction = 0)
    private Integer distanceToRiver;

    @NotNull
    @Digits(integer = 4, fraction = 0)
    private Integer timeToCityCenterMin;

    @NotNull
    @Digits(integer = 3, fraction = 0)
    private Integer timeToBusStopMin;


    @Size(max = 150)
    private String buildingLocationDetails;

    //return Boolean.valueOf(booleanField);
    @NotNull
    private Boolean parkLot;

    @NotNull
    private Boolean garageAvailable;

    @NotNull
    private Boolean elevatorAvailable;

    @NotNull
    private Boolean connectedToMedia;

    @NotBlank
    @Size(min=3, max = 15)
    private String buildingConstructionType;

    @NotNull
    private Long developerId;

    @NotNull
    private Boolean primaryMarket;

    @NotNull
//    @Digits(fraction = 0, integer = 3)
    private Integer numberOfApartments;

    @Digits(fraction = 0, integer = 20)
    private Integer buildingSection;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate buildingRealizationTerm;

    @NotBlank
    @URL
    private String photosUrl;
}
