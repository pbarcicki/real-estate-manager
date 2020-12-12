package projects.realestatemanager.domain.model;


import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "apartments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(of = "id") //todo ewentualnie do zmiany
public class Apartment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int floor;

    @Column(nullable = false, name = "on_corner")
    private boolean onCorner;

    @Column(nullable = false)
    private double area;

    @Column(nullable = false, name = "rooms_number")
    private int roomsNumber;

    //rodzaj kuchni jako string
    @Column(nullable = false, name = "type_of_kitchen")
    private String typeOfKitchen;

    //cena może być niepodana
    @Column(nullable = false)
    private int price;

    @Column(nullable = false, name = "square_meter_price")
    private double squareMeterPrice;

    //stan deweloperski/po wykończeniu/stary remont (enum???)
    @Column(nullable = false, name = "market_type")
    private String marketType;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    // tutaj nie wiem dokładnie
    private boolean exclusivity;
    //plan i zdjęcia TODO

    @Column(nullable = true, name = "windows_direction")
    private String windowsDirection;

    //todo enum?
    @Column(nullable = false)
    private String view;

    @Column(nullable = false, name = "storage_room")
    private boolean storageRoom;

    @Column(nullable = true)
    private String comment;

//    @ManyToOne
//    @JoinColumn(name = "building_id")
//    private Building building;








}


