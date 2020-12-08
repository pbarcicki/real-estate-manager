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
import projects.realestatemanager.web.command.CreateUserCommand;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j @RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Transactional
    public void add(CreateUserCommand createUserCommand) {
        log.debug("Data to create user: {}", createUserCommand);
        User user = userConverter.form(createUserCommand);
        userRepository.save(user);
        log.debug("Saved client: {}", user);

    }

    public List<UserSummary> findUsers() {
        log.debug("Getting user information");
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findAll().stream()
                .map(userConverter::toUserSummary)
                .collect(Collectors.toList());
    }
}
