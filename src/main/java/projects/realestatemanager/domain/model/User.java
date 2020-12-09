package projects.realestatemanager.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@ToString(exclude = "userPassword")
@EqualsAndHashCode(of = "username")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, name = "user_password")
    private String userPassword;

    @Column(nullable = false, name = "user_email")
    private String userEmail;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "role")
    private Set<String> roles = new HashSet<>();

    @Column(nullable = false, name = "is_active")
    private boolean isActive;

    @ManyToMany(mappedBy = "user")
    @Column(nullable = false)
    private List<Client> client;



}
