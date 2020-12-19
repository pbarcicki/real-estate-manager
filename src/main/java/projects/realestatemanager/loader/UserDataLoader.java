package projects.realestatemanager.loader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import projects.realestatemanager.domain.model.User;
import projects.realestatemanager.domain.repository.ClientRepository;
import projects.realestatemanager.domain.repository.UserRepository;

import java.util.Set;

@Component @Profile("heroku")
@Slf4j @RequiredArgsConstructor
public class UserDataLoader implements DataLoader{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public int getOrder(){
        return Integer.MIN_VALUE;
    }

    @Transactional
    public void loadData(){
      User user1= User.builder()
              .username("tom1")
              .userEmail("tom@gmail.com")
              .userPassword(passwordEncoder.encode("tom123"))
              .isActive(true)
              .roles(Set.of("ROLE_USER"))
              .build();
      User user2= User.builder()
              .username("tina12")
              .userPassword(passwordEncoder.encode("tina1234"))
              .userEmail("tina1@linkedin.com")
              .isActive(true)
              .roles(Set.of("ROLE_ADMIN"))
              .build();
      userRepository.save(user1);
      userRepository.save(user2);
      log.debug("Saved users: {} and {}", user1, user2);
    }
}
