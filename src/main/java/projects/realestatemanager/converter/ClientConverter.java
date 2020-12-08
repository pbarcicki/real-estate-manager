package projects.realestatemanager.converter;

import org.springframework.stereotype.Component;
import projects.realestatemanager.data.client.ClientSummary;
import projects.realestatemanager.domain.model.Client;
import projects.realestatemanager.web.command.CreateClientCommand;

@Component
public class ClientConverter {
    public Client form(CreateClientCommand createClientCommand) {
        return Client.builder()
                .clientName(createClientCommand.getClientName())
                .clientContactNumber(createClientCommand.getClientContactNumber())
                .clientContactEmail(createClientCommand.getClientContactEmail())
                .clientInterest(createClientCommand.getClientInterest())
                .build();
    }

    public ClientSummary toClientSummary(Client client) {
        return ClientSummary.builder()
                .clientName(client.getClientName())
                .clientContactEmail(client.getClientContactEmail())
                .clientRegistrationDate(client.getClientRegistrationDate())
                .clientContactNumber(client.getClientContactNumber())
                .clientInterest(client.getClientInterest())
                .build();
    }
}
