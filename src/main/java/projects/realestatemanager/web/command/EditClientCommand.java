package projects.realestatemanager.web.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Builder
public class EditClientCommand {

    private Long id;
    @NotNull
    @Size(min=3, max = 64)
    private String clientName;
    @NumberFormat
    @NotNull
    private String clientContactNumber;
    @Email
    private String clientContactEmail;
    @NotNull @Size(min=3, max = 160)
    private String clientInterest;
    private Boolean isActive;
    private Boolean favourite;

}
