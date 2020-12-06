package projects.realestatemanager.domain.model;


import lombok.*;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "apartments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class Apartment {
    @javax.persistence.Id
    @GeneratedValue
    @Id
    //private Table flats;
    private Long id;
    @Column(nullable = false,name = "floor")
    private int floor;
    @Column(nullable = false, name = "on_corner")
    private boolean onCorner;
    @Column(nullable = false, name = "area")
    private double area;
    @Column(nullable = false, name = "rooms")
    private int rooms;
    //rodzaj kuchni jako string
    @Column(nullable = false, name = "kitchen")
    private String kitchen;
    //cena może być niepodana
    @Column(nullable = true, name = "price")
    private int price;
    @Column(nullable = false, name = "square_price")
    private double squarePrice;
    //rynek jako string
    @Column(nullable = false, name = "market_type")
    private String marketType;
    @Column(nullable = false, name = "status")
    private String status;
    @Column(nullable = false, name = "exclusivity")
    // tutaj nie wiem dokładnie
    private boolean exclusivity;
    //plan i zdjęcia TODO
    @Column(nullable = false, name = "windows_direction")
    private String windowsDirections;
    @Column(nullable = false, name = "view")
    private String view;
    @Column(nullable = false, name = "compartment")
    private boolean compartment;
    @Column(nullable = false, name = "comment")
    private String comment;






}


