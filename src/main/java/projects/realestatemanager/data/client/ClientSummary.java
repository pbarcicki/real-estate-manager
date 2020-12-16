package projects.realestatemanager.data.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import projects.realestatemanager.domain.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientSummary {

    private Long id;

    private String clientName;

    private String clientContactNumber;

    private String clientContactEmail;

    private String clientInterest;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate clientRegistrationDate;

    private Boolean isActive;

    private List<User> user;

    private Boolean favourite;
}
