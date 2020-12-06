package projects.realestatemanager.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@EqualsAndHashCode(of = "userName")

@Entity
@Table(name = "users")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@ToString(exclude = "userPassword")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, name = "user_name")
    private String userName;

    @Column(nullable = false, name = "user_password")
    private String userPassword;

    @Column(nullable = false, name = "user_email")
    private String userEmail;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "role")
    private Set<String> roles = new HashSet<>();


    @ManyToMany(mappedBy = "user")
    @Column(nullable = false)
    private List<Client> client;









}
