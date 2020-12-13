package projects.realestatemanager.web.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateClientCommand {

    @NotNull
    @Size(min=3, max = 64)
    private String clientName;
    @NumberFormat @NotNull
    private String clientContactNumber;
    @Email
    private String clientContactEmail;
    @NotNull @Size(min=3, max = 160)
    private String clientInterest;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate clientRegistrationDate;
    private Boolean isActive;




}
