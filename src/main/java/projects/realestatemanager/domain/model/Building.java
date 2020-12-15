package projects.realestatemanager.domain.model;

import lombok.*;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "building")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@ToString (exclude = "apartments")
@EqualsAndHashCode(of = {"street", "buildingNumber"})
public class Building {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //todo lista regionów
    @Column(nullable = false)
    private String region;

    @Column(name = "is_active")
    private Boolean isActive;

    //todo lista miast
    @Column(nullable = false)
    private String city;

    //todo lista dzielnic???
    @Column(nullable = false)
    private String district;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false, name = "building_number")
    private String buildingNumber;

    @Column(name = "building_details")
    private String buildingDetails;

    @Column(nullable = false, name = "distance_to_kindergarten")
    private Integer distanceToKindergarten;

    @Column(nullable = false, name = "distance_to_school")
    private Integer distanceToSchool;

    @Column(nullable = false, name = "distance_to_shopping_centers")
    private Integer distanceToShoppingCenters;

    @Column(nullable = false, name = "distance_to_park")
    private Integer distanceToPark;

    @Column(nullable = false, name = "distance_to_river")
    private Integer distanceToRiver;

    @Column(nullable = false, name = "time_to_city_center_min")
    private Integer timeToCityCenterMin;

    @Column(nullable = false, name = "time_to_bus_stop_min")
    private Integer timeToBusStopMin;

    @Column(name = "building_location_details")
    private String buildingLocationDetails;

    @Column(name = "is_parking_available")
    private Boolean isParkingAvailable;

    @Column(name = "is_garage_available")
    private Boolean isGarageAvailable;

    @Column(name = "is_elevator_available")
    private Boolean isElevatorAvailable;

    //todo enum yes/no/not given?
    @Column(name = "is_connected_to_media")
    private Boolean isConnectedToMedia;

    @Column(nullable = false, name = "building_construction_type")
    private String buildingConstructionType;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Developer developer;

    private String developerName;

    @Column(name = "is_primary_market")
    private Boolean isPrimaryMarket;

    @Column(nullable = false, name = "number_of_apartments")
    private Integer numberOfApartments;

    @Column(name = "building_section")
    private Integer buildingSection;

    @Column(nullable = false, name = "building_realization_term")
    private LocalDate buildingRealizationTerm;


    //todo Object with photo???
    private String photosUrl;

    @Column(nullable = false, name = "creation_date")
    private LocalDate creationDate;

    @Column(name = "edit_date")
    private LocalDate editDate;

    @OneToMany(mappedBy = "building")
    private List<Apartment> apartments;

}
