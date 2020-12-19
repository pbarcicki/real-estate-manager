package projects.realestatemanager.domain.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "username")
@ToString(exclude = {"userPassword", "clients", "buildings", "apartments"})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, name = "password")
    private String userPassword;

    @Column(nullable = false, name = "user_email")
    private String userEmail;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "username",
                    referencedColumnName = "username"),
            indexes = @Index(
                    name = "users_roles_username_idx",
                    columnList = "username"))
    @Column(name = "role")
    private Set<String> roles = new HashSet<>();

    @Column(nullable = false, name = "active")
    private Boolean isActive;

    @ManyToMany(mappedBy = "users")
    @Column(nullable = false)
    private List<Client> clients;

    public void addClient(Client client) {
        this.clients.add(client);
        client.getUsers().add(this);
    }

    public void removeClient(Client client) {
        this.clients.remove(client);
        client.getUsers().remove(this);
    }

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "users_favourite_buildings",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "building_id")

    )
    private Set<Building> buildings = new HashSet<>();

    public void addBuilding(Building building) {
        this.buildings.add(building);
        building.getUsers().add(this);
    }

    public void removeBuilding(Building building) {
        this.buildings.remove(building);
        building.getUsers().remove(this);
    }

//    @ManyToMany(mappedBy = "users")
//    private Set<Apartment> apartments = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_favourite_apartments",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "apartment_id")
    )
    private Set<Apartment> apartments = new HashSet<>();

    public void addApartment(Apartment apartment) {
        this.apartments.add(apartment);
        apartment.getUsers().add(this);
    }

    public void removeApartment(Apartment apartment) {
        this.apartments.remove(apartment);
        apartment.getUsers().remove(this);
    }
}
