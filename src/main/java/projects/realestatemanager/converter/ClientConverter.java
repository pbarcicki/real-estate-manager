package projects.realestatemanager.converter;

import org.springframework.stereotype.Component;
import projects.realestatemanager.data.client.ClientSummary;
import projects.realestatemanager.domain.model.Client;
import projects.realestatemanager.web.command.CreateClientCommand;
import projects.realestatemanager.web.command.EditClientCommand;

@Component
public class ClientConverter {
    public Client form(CreateClientCommand createClientCommand) {
        return Client.builder()
                .clientName(createClientCommand.getClientName())
                .clientContactNumber(createClientCommand.getClientContactNumber())
                .clientContactEmail(createClientCommand.getClientContactEmail())
                .clientInterest(createClientCommand.getClientInterest())
                .clientRegistrationDate(createClientCommand.getClientRegistrationDate())
                .build();
    }

    public Client from(EditClientCommand editClientCommand, Client client){
        client.setClientName(editClientCommand.getClientName());
        client.setClientContactEmail(editClientCommand.getClientContactEmail());
        client.setClientContactNumber(editClientCommand.getClientContactNumber());
        client.setClientInterest(editClientCommand.getClientInterest());
        return client;
    }

    public ClientSummary toClientSummary(Client client) {
        return ClientSummary.builder()
                .clientName(client.getClientName())
                .clientContactEmail(client.getClientContactEmail())
                .clientContactNumber(client.getClientContactNumber())
                .clientInterest(client.getClientInterest())
                .clientRegistrationDate(client.getClientRegistrationDate())
                .build();
    }
}
