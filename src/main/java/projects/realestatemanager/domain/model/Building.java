package projects.realestatemanager.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "buildings")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@ToString
public class Building {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //todo lista regionów
    @Column(nullable = false)
    private String region;

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

    @Column(nullable = false, name = "is_parking_available")
    private boolean isParkingAvailable;

    @Column(nullable = false, name = "is_garage_available")
    private boolean isGarageAvailable;

    @Column(nullable = false, name = "building_construction_type")
    private String buildingConstructionType;

    //todo relation or class embedable (słownik nazw)
    @ManyToOne
    @JoinColumn(name = "developer_id")
    @Column(nullable = false)
    private Developer developer;

    @Column(nullable = false, name = "is_elevator_available")
    private boolean isElevatorAvailable;


    @Column(nullable = false, name = "is_primary_market")
    private boolean isPrimaryMarket;

    @Column(name = "building_section")
    private Integer buildingSection;

    @Column(nullable = false, name = "building_realization_term")
    private Date buildingRealizationTerm;

    @Column(nullable = false, name = "is_building_finished")
    private boolean isBuildingFinished;

    //todo enum yes/no/not given?
    @Column(nullable = false, name = "is_connected_to_media")
    private boolean isConnectedToMedia;

    //todo Object with photo???
    private String photosUrl;

    @OneToMany(mappedBy = "buildings")
    private List<Apartment> apartments;

}
