package projects.realestatemanager.data.apartment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

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
    private double area;

    @NumberFormat
    private  int roomsNumber;

    private String typeOfKitchen;

    @NumberFormat
    private int price;

    @NumberFormat
    private double squareMeterPrice;

    private String marketType;

    private String status;

    private boolean exclusivity;

    private String windowsDirection;

    private String view;

    private boolean storageRoom;

    private  String comment;


}
