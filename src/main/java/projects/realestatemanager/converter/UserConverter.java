package projects.realestatemanager.converter;

import org.springframework.stereotype.Component;
import projects.realestatemanager.data.user.UserSummary;
import projects.realestatemanager.domain.model.User;
import projects.realestatemanager.web.command.CreateUserCommand;
import projects.realestatemanager.web.command.EditUserCommand;

@Component
public class UserConverter {

    public User form(CreateUserCommand createUserCommand) {
        return User.builder()
                .username(createUserCommand.getUsername())
                .userPassword(createUserCommand.getUserPassword())
                .userEmail(createUserCommand.getUserEmail())
                .build();
    }
    public User from(EditUserCommand editUserCommand, User user){
        user.setUsername(editUserCommand.getUsername());
        user.setUserEmail(editUserCommand.getUserEmail());
        return user;
    }

    public UserSummary toUserSummary(User user) {
        return UserSummary.builder()
                .username(user.getUsername())
                .userEmail(user.getUserEmail())
                .build();
    }
}
