package projects.realestatemanager.loader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import projects.realestatemanager.domain.model.Building;
import projects.realestatemanager.domain.repository.BuildingRepository;
import projects.realestatemanager.domain.repository.DeveloperRepository;

import java.time.LocalDate;

@Component
@Profile("heroku")
@Slf4j
@RequiredArgsConstructor
public class BuildingDataLoader implements DataLoader{

    private final BuildingRepository buildingRepository;

    public int getOrder(){
        return Integer.MIN_VALUE;
    }

    @Transactional
    public void loadData() {
        Building building1 = Building.builder()
                .buildingConstructionType("Brick")
                .buildingDetails("vestibulum sagittis sapien cum sociis natoque penatibus et magnis")
                .buildingLocationDetails("interdum mauris non ligula pellentesque ultrices")
                .buildingNumber("20")
                .buildingRealizationTerm(LocalDate.of(2020,5,5))
                .buildingSection(2)
                .city("Wrocław")
                .creationDate(LocalDate.of(2020,3,5))
                .distanceToKindergarten(30)
                .distanceToPark(5)
                .distanceToRiver(5)
                .distanceToSchool(20)
                .distanceToShoppingCenters(10)
                .district("tempor turpis")
                .isActive(true)
                .isConnectedToMedia(true)
                .isElevatorAvailable(true)
                .isGarageAvailable(false)
                .isParkingAvailable(true)
                .isPrimaryMarket(true)
                .numberOfApartments(54)
                .photosUrl("http://eventbrite.com")
                .region("Pomerian")
                .street("Podwale")
                .timeToBusStopMin(12)
                .timeToCityCenterMin(10)
                .developerName("Paul")
                .build();

        Building building2 = Building.builder()
                .buildingDetails("Panel")
                .buildingLocationDetails("non interdum in ante vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae duis faucibus accumsan odio curabitur convallis duis")
                .buildingNumber("23")
                .buildingRealizationTerm(LocalDate.of(2022, 12,2))
                .buildingSection(3)
                .city("Katowice")
                .creationDate(LocalDate.of(2019,5,17))
                .distanceToKindergarten(10)
                .distanceToPark(5)
                .distanceToRiver(20)
                .distanceToSchool(25)
                .distanceToShoppingCenters(30)
                .district("primis")
                .isActive(true)
                .isConnectedToMedia(true)
                .isElevatorAvailable(true)
                .isGarageAvailable(true)
                .isParkingAvailable(true)
                .isPrimaryMarket(true)
                .numberOfApartments(20)
                .photosUrl("https://hatena.ne.jp")
                .region("West Pomerian")
                .street("Mariacka")
                .timeToBusStopMin(5)
                .timeToCityCenterMin(25)
                .buildingConstructionType("Dom")
                .developerName("Frank")
                .build();
        buildingRepository.save(building1);
        buildingRepository.save(building2);
        log.debug("Saved building: {} and {}", building1, building2);
    }
}
