package projects.realestatemanager.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="developer")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@EqualsAndHashCode(of = "developerName")
public class Developer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, name = "developer_name") //todo zmienić na możliwość dodania kilku kontaktów dla developera
    private String developerName;

    @Column(nullable = false, name = "developer_contact_person")
    private String developerContactPerson;

    @Column(nullable = false, name = "is_active")
    private boolean isActive;

    @Column(nullable = false, name = "developer_contact_number")
    private String developerContactNumber;


    @OneToMany(mappedBy = "developer")
    private List<Building> buildings;

}
