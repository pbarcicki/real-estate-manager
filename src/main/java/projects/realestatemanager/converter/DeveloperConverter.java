package projects.realestatemanager.converter;

import org.springframework.stereotype.Component;
import projects.realestatemanager.data.developer.DeveloperSummary;
import projects.realestatemanager.domain.model.Developer;
import projects.realestatemanager.web.command.CreateDeveloperCommand;
import projects.realestatemanager.web.command.EditDeveloperCommand;

@Component
public class DeveloperConverter {
    public Developer from(CreateDeveloperCommand createDeveloperCommand) {
        return Developer.builder()
                .developerName(createDeveloperCommand.getDeveloperName())
                .developerContactNumber(createDeveloperCommand.getDeveloperContactNumber())
                .developerContactPerson(createDeveloperCommand.getDeveloperContactPerson())
                .build();
    }

    //    todo rozwiązać problem z edycją dewelopera
    public Developer from(EditDeveloperCommand editDeveloperCommand, Developer developer) {
        developer.setDeveloperName(editDeveloperCommand.getDeveloperName());
        developer.setDeveloperContactPerson(editDeveloperCommand.getDeveloperContactPerson());
        developer.setDeveloperContactNumber(editDeveloperCommand.getDeveloperContactNumber());
        developer.setIsActive(editDeveloperCommand.getIsActive());
        return developer;
    }

    public DeveloperSummary developerSummary(Developer developer) {
        return DeveloperSummary.builder()
                .id(developer.getId())
                .name(developer.getDeveloperName())
                .contactPerson(developer.getDeveloperContactPerson())
                .contactNumber(developer.getDeveloperContactNumber())
                .isActive(developer.getIsActive())
                .build();
    }
}