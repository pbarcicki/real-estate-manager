package projects.realestatemanager.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "clients")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
@EqualsAndHashCode
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, name = "client_name")
    private String clientName;

    @Column(nullable = false, name = "client_registration_date")
    private LocalDate clientRegistrationDate;

    @Column(nullable = false, name = "client_contact_number")
    private String clientContactNumber;

    @Column(nullable = false, name = "client_contact_email")
    private String clientContactEmail;

    @Column(nullable = false, name = "client_interest")
    private String clientInterest;

    @ManyToMany
    @JoinColumn(name = "user_id")
    private User user;



}
