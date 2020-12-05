package projects.realestatemanager.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="developers")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@EqualsAndHashCode(of = "developerName")
public class Developer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true) //todo zmienić na możliwość dodania kilku kontaktów dla developera
    private String developerName;

    @Column(nullable = false)
    private String developerContactPerson;

    @Column(nullable = false)
    private String developerContactNumber;
}
