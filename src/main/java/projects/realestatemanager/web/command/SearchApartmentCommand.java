package projects.realestatemanager.web.command;

import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchApartmentCommand {

    //building
    private Long developerId;

    //building
    @Size(max = 40)
    private String street;

    @NumberFormat
    private Integer minFloor;

    @NumberFormat
    private Integer maxFloor;

    @NumberFormat
    private Integer minArea;

    @NumberFormat
    private Integer maxArea;

    @NumberFormat
    private Integer minRoomsNumber;

    @NumberFormat
    private Integer maxRoomsNumber;

    @Size(max = 15)
    private String typeOfKitchen;

    @NumberFormat
    private Integer minPrice;

    @NumberFormat
    private Integer maxPrice;

    @NumberFormat
    private Integer minPricePerSquareMeter;

    @NumberFormat
    private Integer maxPricePerSquareMeter;

    @Size(max = 15)
    private String marketType;

    //building
    @Digits(integer = 4, fraction = 0)
    private Integer maxDistanceToKindergarten;

    //building
    @Digits(integer = 4, fraction = 0)
    private Integer maxDistanceToSchool;

    //building
    @Digits(integer = 4, fraction = 0)
    private Integer maxDistanceToShoppingCenters;

    //building
    @Digits(integer = 4, fraction = 0)
    private Integer maxDistanceToPark;

    private String windowsDirection;

    private String view;

    private String status;

    @BooleanFlag
    private Boolean exclusivity;

    @BooleanFlag
    private Boolean storageRoom;

    @BooleanFlag
    private Boolean onCorner;

    //building
    @BooleanFlag
    private Boolean isParkingAvailable;

    //building
    @BooleanFlag
    private Boolean isGarageAvailable;

    //building
    @BooleanFlag
    private Boolean isElevatorAvailable;

    //building
    @BooleanFlag
    private Boolean isConnectedToMedia;

    //building
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate minBuildingRealizationTerm;

    //building
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate maxBuildingRealizationTerm;



}
