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
import projects.realestatemanager.exception.ClientAlreadyExistException;
import projects.realestatemanager.exception.ClientDoesNotExistException;
import projects.realestatemanager.web.command.CreateClientCommand;
import projects.realestatemanager.web.command.EditClientCommand;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j @RequiredArgsConstructor
@Transactional
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientConverter clientConverter;

    public List<ClientSummary> findClients() {
        log.debug("Getting customer information");
        return clientRepository.findAll().stream()
                .map(clientConverter::toClientSummary)
                .collect(Collectors.toList());

    }


    public void add(CreateClientCommand createClientCommand)  {
        log.debug("Data to create client: {}", createClientCommand);
        Client clientToCreate = clientConverter.form(createClientCommand);
        log.debug("Converted client entity to add: {}", clientToCreate);
        if(clientRepository.existsByClientContactEmail(
                 clientToCreate.getClientContactEmail()
                )){
            log.debug("Tried to add existing client");
            throw new ClientAlreadyExistException(String.format(
                    "Client with %s clientEmail already exist in DB",
                    clientToCreate.getClientContactEmail()
            ));
        }
        clientToCreate.setActive(true);
        clientToCreate.setClientRegistrationDate(LocalDate.now());
        clientRepository.save(clientToCreate);
        log.debug("Saved client: {}", clientToCreate);

    }

    public boolean edit(EditClientCommand editClientCommand){
        Long id = editClientCommand.getId();
        if(!clientRepository.existsById(id)){
            log.debug("Client with id: {} doesn't exist", id);
            throw new ClientDoesNotExistException(String.format(
                    "Client with id: {} doesn't exist",id));
        }
        Client client = clientRepository.getOne(id);
        log.debug("Client to edit: {}", client);
        client =  clientConverter.from(editClientCommand, client);
        log.debug("Modified client: {}", client);
        return true;
    }


    public ClientSummary showClient(Long id) {
        log.debug("Client search with id: {}",id);
        Client client = clientRepository.getOne(id);
        if(!clientRepository.existsById(id)){
            log.debug("Client with id: {} doesn't exist", id);
            throw new ClientDoesNotExistException(
                    String.format("Client with id: {} doesn't exist", id)
            );
        }
        return clientConverter.toClientSummary(client);
    }
}






