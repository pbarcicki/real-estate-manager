package projects.realestatemanager.web.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserCommand {

    @NotNull
    private String username;
    @NotBlank @Size(min=4, max = 12)
    private String userPassword;
    @Email @NotNull
    private String userEmail;
    private Boolean isActive;
}
