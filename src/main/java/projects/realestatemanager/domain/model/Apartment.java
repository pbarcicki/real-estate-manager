package projects.realestatemanager.domain.model;


import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "apartment")
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
    private Integer floor;

    @Column(nullable = false, name = "on_corner")
    private Boolean onCorner;

    @Column(nullable = false)
    private Integer area;

    @Column(nullable = false, name = "rooms_number")
    private Integer roomsNumber;

    //rodzaj kuchni jako string
    @Column(nullable = false, name = "type_of_kitchen")
    private String typeOfKitchen;

    //cena może być niepodana
    @Column(nullable = false)
    private Integer price;

    //stan deweloperski/po wykończeniu/stary remont (enum???)
    @Column(nullable = false, name = "market_type")
    private String marketType;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    // tutaj nie wiem dokładnie
    private Boolean exclusivity;
    //plan i zdjęcia TODO

    @Column(name = "windows_direction")
    private String windowsDirection;

    //todo enum?
    @Column(nullable = false)
    private String view;

    @Column(nullable = false, name = "storage_room")
    private Boolean storageRoom;

    private String comment;

    @Column(nullable = false)
    private Boolean active;

    @Column(nullable = false)
    private LocalDate creationDate;

    @Column(name = "photos_url")
    private String photosUrl;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

}


