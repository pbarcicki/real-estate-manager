package projects.realestatemanager.data.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class ClientSummary {

    private String clientName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate clientRegistrationDate;

    private String clientContactNumber;

    private String clientContactEmail;

    private String clientInterest;



}
