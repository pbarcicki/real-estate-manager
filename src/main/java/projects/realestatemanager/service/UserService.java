package projects.realestatemanager.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projects.realestatemanager.converter.UserConverter;
import projects.realestatemanager.data.user.UserSummary;
import projects.realestatemanager.domain.model.User;
import projects.realestatemanager.domain.repository.UserRepository;
import projects.realestatemanager.exception.ClientAlreadyExistException;
import projects.realestatemanager.exception.UserAlreadyExistException;
import projects.realestatemanager.web.command.CreateUserCommand;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j @RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public List<UserSummary> findUsers() {
        log.debug("Getting user information");
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findAll().stream()
                .map(userConverter::toUserSummary)
                .collect(Collectors.toList());
    }


    public void add(CreateUserCommand createUserCommand) {
        log.debug("Data to create userToCreate: {}", createUserCommand);
        User userToCreate = userConverter.form(createUserCommand);
        log.debug("Converted user entity to add: {}", userToCreate);
        if(userRepository.existsByUserEmail(
                userToCreate.getUserEmail())){
            throw new UserAlreadyExistException(String.format(
                    "User with %s userEmail already exist in DB",
                    userToCreate.getUserEmail()
            ));
        }
        userToCreate.setActive(true);
        userRepository.save(userToCreate);
        log.debug("Saved client: {}", userToCreate);

    }


}
