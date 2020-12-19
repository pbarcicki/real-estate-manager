//package loaders;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.annotation.Profile;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//import projects.realestatemanager.domain.model.User;
//import projects.realestatemanager.domain.repository.UserRepository;
//import java.util.Optional;
//
//@Component
//@Slf4j
//@RequiredArgsConstructor
//@Profile("heroku")
//public class DataLoaderManager {
//
//    private final UserRepository userRepository;
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void loadData() {
//        Optional<User> optionalUser = userRepository.findByUsername("test");
//
//        if(optionalUser.isPresent()) {
//            User user = optionalUser.get();
//
//        }
//
//        log.debug("Loading default data");
//    }
//
//}
