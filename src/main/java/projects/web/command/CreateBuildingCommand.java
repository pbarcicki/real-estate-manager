package projects.web.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateBuildingCommand {

    @NotNull
    private Long id;
    @NotNull @Size(min=3, max=25)
    private String region;
    @NotNull @Size(min=3, max=25)
    private String city;
    @NotNull @Size(min=3, max=40)
    private String district;
    @NotNull @Size(min=3, max=40)
    private String street;
    @NotNull @NumberFormat
    private String buildingNumber;
    @NotNull @NumberFormat
    private String buildingDetails;
    @NotNull
    private Integer distanceToKindergarten;
    @NotNull
    private Integer distanceToSchool;
    @NotNull
    private Integer distanceToShoppingCenters;
    @NotNull
    private Integer distanceToPark;
    @NotNull
    private Integer distanceToRiver;
    @NotNull
    private Integer timeToCityCenterMin;
    @NotNull
    private Integer timeToBusStopMin;
    @NotNull @Size (min=5, max= 200)
    private String buildingLocationDetails;
    @NotNull
    private boolean isParkingAvailable;
    @NotNull
    private boolean isGarageAvailable;
    @NotNull @Size(min=3, max=30)
    private String buildingConstructionType;



}
