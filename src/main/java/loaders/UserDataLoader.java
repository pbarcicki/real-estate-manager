//package loaders;
//
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import projects.realestatemanager.domain.model.User;
//import projects.realestatemanager.domain.repository.UserRepository;
//
//import java.util.Set;
//
//@Component
//@Slf4j
//@RequiredArgsConstructor
//@Data
//public class UserDataLoader {
//
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public void loadData() {
//        User.builder()
//                .username("tes")
//                .userEmail("test@test.io")
//                .userPassword(passwordEncoder.encode("Pa55"))
//                .isActive(true)
//                .roles(Set.of("ROLE_USER"))
//                .build();
//    }
//}
