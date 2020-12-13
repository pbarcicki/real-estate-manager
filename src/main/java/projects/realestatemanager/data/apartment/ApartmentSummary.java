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

    @NumberFormat
    private int floor;

    private boolean onCorner;

    @NumberFormat
    private int area;

    @NumberFormat
    private  int roomsNumber;

    private String typeOfKitchen;

    @NumberFormat
    private int price;

    @NumberFormat
    private int squareMeterPrice;

    private String marketType;

    private String status;

    private boolean exclusivity;

    private String windowsDirection;

    private String view;

    private boolean storageRoom;

    private  String comment;

    private Boolean active;

    private LocalDate creationDate;

    private String photosUrl;


}
