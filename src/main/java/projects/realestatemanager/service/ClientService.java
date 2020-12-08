package projects.realestatemanager.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projects.realestatemanager.converter.ClientConverter;
import projects.realestatemanager.data.client.ClientSummary;
import projects.realestatemanager.domain.model.Client;
import projects.realestatemanager.domain.repository.ClientRepository;
import projects.realestatemanager.web.command.CreateClientCommand;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j @RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientConverter clientConverter;

    @Transactional
    public void add(CreateClientCommand createClientCommand) {
        log.debug("Data to create client: {}", createClientCommand);
        Client clientToCreate = clientConverter.form(createClientCommand);
        clientRepository.save(clientToCreate);
        log.debug("Saved client: {}", clientToCreate);

    }

    public List<ClientSummary> findUserClients() {
        log.debug("Getting customer information");
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return clientRepository.findAllByUserUsername(username).stream()
                .map(clientConverter::toClientSummary)
                .collect(Collectors.toList());

    }
}
