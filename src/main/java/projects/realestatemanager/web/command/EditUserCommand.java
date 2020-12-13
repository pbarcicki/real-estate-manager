package projects.realestatemanager.web.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Builder
public class EditUserCommand {

    private Long id;
    @NotNull
    @Size(min=3, max = 64)
    private String username;
    @Email
    private String userEmail;
    private Boolean isActive;



}
