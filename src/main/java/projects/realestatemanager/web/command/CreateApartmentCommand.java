package projects.realestatemanager.web.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateApartmentCommand {
    @NotBlank
    @Size(min=1, max = 3)
    private int floor;

    @NotBlank
    private boolean onCorner;

    @NotBlank
    private double area;

    @NotBlank
    private int roomsNumber;

    @NotBlank
    @Size(min = 3, max = 10)
    private String typeOfKitchen;

    @NotBlank
    private int price;

    @NotBlank
    private int squareMeterPrice;

    @NotBlank
    @Size(min = 1, max = 4)
    private String marketType;

    @NotBlank
    @Size(min = 1, max = 20)
    private String status;

    @NotBlank
    @Size (min = 1, max = 10)
    private String exclusivity;

    @NotBlank
    @Size(min = 1, max = 30)
    private String view;

    @NotBlank
    private boolean storageRoom;

    @NotBlank
    @Size(min = 1, max = 160)
    private String comment;

}
