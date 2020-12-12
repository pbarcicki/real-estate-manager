package projects.realestatemanager.data.developer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import projects.realestatemanager.domain.model.Building;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeveloperSummary {
    private Long id;
    private String name;
    private String contactPerson;
    private String contactNumber;
    private boolean isActive;
    private List<Building> buildings;
}