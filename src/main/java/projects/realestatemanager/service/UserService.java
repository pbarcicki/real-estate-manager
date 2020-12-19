package projects.realestatemanager.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projects.realestatemanager.converter.UserConverter;
import projects.realestatemanager.data.user.UserSummary;
import projects.realestatemanager.domain.model.Building;
import projects.realestatemanager.domain.model.User;
import projects.realestatemanager.domain.repository.UserRepository;
import projects.realestatemanager.exception.EntityDoesNotExistException;
import projects.realestatemanager.exception.UserAlreadyExistException;
import projects.realestatemanager.web.command.CreateUserCommand;
import projects.realestatemanager.web.command.EditUserCommand;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;
    private final PasswordEncoder passwordEncoder;

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
        if (userRepository.existsByUserEmail(
                userToCreate.getUserEmail())) {
            throw new UserAlreadyExistException(String.format(
                    "User with %s userEmail already exist in DB",
                    userToCreate.getUserEmail()
            ));
        }
        setDefaultActive(userToCreate);
        setEncodedPassword(userToCreate);
        setDefaultRole(userToCreate);
        userRepository.save(userToCreate);
        log.debug("Saved client: {}", userToCreate);

    }

    public boolean edit(EditUserCommand editUserCommand) {
        Long id = editUserCommand.getId();
        if (!userRepository.existsById(id)) {
            log.debug("User with id: {} doesn't exist", id);
            throw new EntityDoesNotExistException(String.format(
                    "User with id: {} doesn't exist", id));
        }
        User user = userRepository.getOne(id);
        log.debug("User to edit: {}", user);
        user = userConverter.from(editUserCommand, user);
        log.debug("Modified user: {}", user);
        return true;
    }

    public UserSummary showUser(Long id) {
        log.debug("User search with id: {}", id);
        User user = userRepository.getOne(id);
        if (!userRepository.existsById(id)) {
            log.debug("User with id: {} doesn't exist", id);
            throw new EntityDoesNotExistException(
                    String.format("User with id: {} doesn't exist", id)
            );
        }
        return userConverter.toUserSummary(user);
    }

    private void setDefaultActive(User userToCreate) {
        userToCreate.setIsActive(Boolean.TRUE);
    }

    private void setDefaultRole(User userToCreate) {
        userToCreate.setRoles(Set.of("ROLE_ADMIN"));
    }

    public boolean delete(Long id) {
        log.debug("Searching user with id: {}", id);
        User user = userRepository.getOne(id);
        if (!userRepository.existsById(id)) {
            log.debug("Client with id: {} doesn't exist", id);
            throw new EntityDoesNotExistException(String.format(
                    "Client with id: {} doesn't exist", id));
        }
        log.debug("Client to delete: {}", user);
        userRepository.delete(user);
        return true;
    }

    private void setEncodedPassword(User userToCreate) {
        userToCreate.setUserPassword(passwordEncoder.encode(userToCreate.getUserPassword()));
    }

    public User findUserByName(String username) {
        return userRepository.getAuthenticatedUser(username);
    }

    public void addBuilding(String username, Building building) {
        userRepository.getAuthenticatedUser(username).addBuilding(building);
    }

    public void removeBuilding(String username, Building building){
        userRepository.getAuthenticatedUser(username).removeBuilding(building);
    }
}
