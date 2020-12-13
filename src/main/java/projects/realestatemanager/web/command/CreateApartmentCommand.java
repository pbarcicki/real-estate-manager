package projects.realestatemanager.web.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateApartmentCommand {
    @NotNull
    @Size(min=1, max = 3)
    private Integer floor;

    @NotNull
    private Boolean onCorner;

    @NotNull
    private Double area;

    @NotNull
    private Integer roomsNumber;

    @NotNull
    @Size(min = 3, max = 10)
    private String typeOfKitchen;

    @NotNull
    private Integer price;

    @NotNull
    private Integer squareMeterPrice;

    @NotBlank
    @Size(min = 1, max = 4)
    private String marketType;

    @NotBlank
    @Size(min = 1, max = 20)
    private String status;

    @NotNull
    @Size (min = 1, max = 10)
    private Boolean exclusivity;

    @Size(min = 3, max = 16)
    private String windowsDirection;

    @NotBlank
    @Size(min = 5, max = 30)
    private String view;

    @NotNull
    private Boolean storageRoom;

    @NotBlank
    @Size(min = 13, max = 160)
    private String comment;

    @NotBlank
    @URL
    private String photosUrl;

    private LocalDate creationDate;



}
