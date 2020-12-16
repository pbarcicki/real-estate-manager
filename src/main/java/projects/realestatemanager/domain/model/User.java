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
@ToString(exclude = {"client", "userPassword"})
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

    @ManyToMany(mappedBy = "user")
    @Column(nullable = false)
    private List<Client> client;
}
