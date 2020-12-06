package projects.realestatemanager.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "clients")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
@EqualsAndHashCode(of = {"client_name", "client_registration_date"})
@ToString
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "client_name")
    private String clientName;

    @Column(nullable = false, name = "client_registration_date")
    private LocalDate clientRegistrationDate;

    @Column(nullable = false, name = "client_contact_number")
    private String clientContactNumber;

    //zmiana nullable na true - na pierwszych etapach rozmow mail moze nie byc podany
    @Column(nullable = true, name = "client_contact_email")
    private String clientContactEmail;

    @Column(nullable = false, name = "client_interest")
    private String clientInterest;

    @ManyToMany
    @JoinColumn(name = "user_id")
    private List<User> user;
}
