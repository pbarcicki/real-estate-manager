package projects.web.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CreateApartmentCommand {

    @NotBlank
    private int floor;
    @NotBlank
    private boolean onCorner;
    @NotBlank
    private double area;
    @NotBlank
    private int roomsNumber;
    @NotBlank
    private String typeOfKitchen;
    @NotBlank
    private int price;
    @NotBlank
    private double squareMeterPrice;
    @NotBlank
    private String marketType;
    @NotBlank
    private String status;
    @NotBlank
    private boolean exclusivity;
    @NotBlank
    private String windowsDirection;
    @NotBlank
    private String view;
    @NotBlank
    private boolean storageRoom;
    @NotBlank
    private String comment;
    @NotBlank
    @URL
    private String apartmentPhotosUrl;



}
