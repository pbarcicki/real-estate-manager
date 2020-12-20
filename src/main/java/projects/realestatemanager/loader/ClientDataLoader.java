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
                .clientInterest("Next to the living room, I want open kitchen.")
                .clientRegistrationDate(LocalDate.of(2020,11,6))
                .isActive(true)
                .build();
        clientRepository.save(client1);
        Client client2 = Client.builder()
                .clientName("Emma Corrin")
                .clientContactEmail("emma@cor.com")
                .clientContactNumber("83970740215")
                .clientRegistrationDate(LocalDate.of(2019,4,16))
                .isActive(true)
                .clientInterest("Next to the bedroom I want little, light bathroom with a toilet and a bath.")
                .build();
        clientRepository.save(client2);
        log.debug("Saved clients: {} and {}", client1, client2);
    }
}
