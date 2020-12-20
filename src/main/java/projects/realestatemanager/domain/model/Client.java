package projects.realestatemanager.domain.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "clients")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
@EqualsAndHashCode(of = {"clientName", "clientRegistrationDate"})
@ToString(exclude = "user")
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

    @Column(nullable = false, name = "is_active")
    private Boolean isActive;

    @ManyToMany
    @JoinColumn(name = "user_id")
    private Set<User> users = new HashSet<>();
}
