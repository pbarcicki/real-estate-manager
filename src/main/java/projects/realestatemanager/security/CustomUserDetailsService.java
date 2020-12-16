package projects.realestatemanager.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import projects.realestatemanager.domain.repository.UserRepository;

import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("Pobieranie UŻYTKOWNIKA o loginie={}", username);
        return userRepository.findUserByUsername(username)
                .map(user -> new User(
                        user.getUsername(),
                        user.getUserPassword(),
                        user.getIsActive(),
                        true,
                        true,
                        true,
                        user.getRoles().stream()
                                .map(SimpleGrantedAuthority::new)
                                .collect(Collectors.toSet())))
                .orElseThrow(
                        () -> new UsernameNotFoundException("Użytkownik nie istnieje :("));
    }
}
