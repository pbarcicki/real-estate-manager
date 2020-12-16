package projects.realestatemanager.data.apartment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApartmentSummary {

    private Long id;

    private Integer floor;

    private Boolean onCorner;

    private Integer area;

    private Integer roomsNumber;

    private String typeOfKitchen;

    private Integer price;

    private Integer pricePerSquareMeter;

    private String marketType;

    private String status;

    private Boolean exclusivity;

    private String windowsDirection;

    private String view;

    private Boolean storageRoom;

    private String comment;

    private Boolean active;

    private LocalDate creationDate;

    private String photosUrl;

    private Boolean favourite;


}