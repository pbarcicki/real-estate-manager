package projects.realestatemanager.data.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import projects.realestatemanager.domain.model.Client;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSummary {

    private String username;
    private String userEmail;
    private Long id;
    private Boolean isActive;
    private List<Client> client;

}
