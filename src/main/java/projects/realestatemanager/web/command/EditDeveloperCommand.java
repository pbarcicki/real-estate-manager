package projects.realestatemanager.web.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.NumberFormat;
import projects.realestatemanager.domain.model.Building;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Builder
public class EditDeveloperCommand {
    @NotBlank
    @Size(min = 3, max = 128)
    private String developerName;

    @NotBlank @Size(min = 3, max = 128)
    private String developerContactPerson;

    @NotNull
    @NumberFormat //?? number format - sprawdzić jak działa!
    private String developerContactNumber;

    private Long id;

    private Boolean isActive;

//    todo uzupełnić poniższe
//    private boolean isActive;
//    private List<Building> buildings;
}