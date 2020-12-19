package projects.realestatemanager.loader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import projects.realestatemanager.domain.model.Developer;
import projects.realestatemanager.domain.repository.DeveloperRepository;

@Component
@Profile("heroku")
@Slf4j
@RequiredArgsConstructor
public class DeveloperDataLoader implements DataLoader{

    private final DeveloperRepository developerRepository;

    public int getOrder(){
        return Integer.MIN_VALUE + 1;
    }

    @Transactional
    public void loadData() {
        Developer developer1 = Developer.builder()
                .developerContactNumber("234765234")
                .developerContactPerson("Guashe")
                .developerName("Ben")
                .isActive(true)
                .build();
        developerRepository.save(developer1);
        Developer developer2 = Developer.builder()
                .developerContactNumber("234000534")
                .developerContactPerson("Ughelli")
                .developerName("Manganitu")
                .isActive(true)
                .build();
        developerRepository.save(developer2);
        log.debug("Saved developers: {} and {}", developer1, developer2);
    }

}
