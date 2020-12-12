package projects.realestatemanager.domain.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "client")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
@EqualsAndHashCode(of = {"clientName", "clientRegistrationDate"})
@ToString
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

    @Column(nullable = false, name = "is_active")
    private boolean isActive;

    @ManyToMany
    @JoinColumn(name = "user_id")
    private List<User> user;
}
