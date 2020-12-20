package projects.realestatemanager.loader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import projects.realestatemanager.domain.model.Client;
import projects.realestatemanager.domain.repository.ClientRepository;

import java.time.LocalDate;

@Component @Profile("heroku")
@Slf4j @RequiredArgsConstructor
public class ClientDataLoader implements DataLoader{
    private final ClientRepository clientRepository;

    public int getOrder(){
        return Integer.MIN_VALUE + 1;
    }

    @Transactional
    public void loadData(){
        Client client1 = Client.builder()
                .clientName("Germana Bremmell")
                .clientContactEmail("gbremmell1x@twitter.com")
                .clientContactNumber("29187300065")
                .clientInterest("Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla.")
                .clientRegistrationDate(LocalDate.now())
                .isActive(true)
                .build();
        clientRepository.save(client1);
        Client client2 = Client.builder()
                .clientName("Gare Chattington")
                .clientContactEmail("gchattington27@dion.ne.jp")
                .clientContactNumber("83970740215")
                .clientRegistrationDate(LocalDate.ofYearDay(2020,14))
                .isActive(true)
                .clientInterest("Donec posuere metus vitae ipsum.")
                .build();
        clientRepository.save(client2);
        log.debug("Saved clients: {} and {}", client1, client2);
    }
}
