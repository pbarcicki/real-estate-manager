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
    private final DeveloperRepository developerRepository;

    public int getOrder(){
        return Integer.MIN_VALUE+1;
    }

    @Transactional
    public void loadData() {
        Building building1 = Building.builder()
                .buildingConstructionType("Panel")
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
                .editDate(LocalDate.of(2020,10,1))
                .timeToBusStopMin(12)
                .timeToCityCenterMin(10)
                .developerName(developerRepository.getOne(1L).getDeveloperName())
                .developer(developerRepository.getOne(1L))
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
                .numberOfApartments(4)
                .photosUrl("https://hatena.ne.jp")
                .region("Silesian")
                .street("Mariacka")
                .timeToBusStopMin(5)
                .timeToCityCenterMin(25)
                .buildingConstructionType("Brick")
                .editDate(LocalDate.of(2010,5,6))
                .developer(developerRepository.getOne(2L))
                .developerName(developerRepository.getOne(2L).getDeveloperName())
                .build();
        Building building3 = Building.builder()
                .buildingDetails("data")
                .buildingLocationDetails("non interdum in ante vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae duis faucibus accumsan odio curabitur convallis duis")
                .buildingNumber("10")
                .buildingRealizationTerm(LocalDate.of(2021, 2,12))
                .buildingSection(4)
                .city("Poznań")
                .creationDate(LocalDate.of(2020,3,27))
                .distanceToKindergarten(550)
                .distanceToPark(200)
                .distanceToRiver(500)
                .distanceToSchool(25)
                .distanceToShoppingCenters(30)
                .district("second")
                .isActive(true)
                .isConnectedToMedia(false)
                .isElevatorAvailable(false)
                .isGarageAvailable(true)
                .isParkingAvailable(false)
                .isPrimaryMarket(true)
                .numberOfApartments(20)
                .photosUrl("https://bigcartel.com")
                .region("West Pomerian")
                .street("Dolna")
                .timeToBusStopMin(15)
                .timeToCityCenterMin(5)
                .buildingConstructionType("Other")
                .developerName(developerRepository.getOne(1L).getDeveloperName())
                .developer(developerRepository.getOne(1L))
                .build();
        Building building4 = Building.builder()
                .buildingDetails("now building")
                .buildingLocationDetails("")
                .buildingNumber("12")
                .buildingRealizationTerm(LocalDate.of(2019, 12,2))
                .buildingSection(7)
                .city("Wrocław")
                .creationDate(LocalDate.of(2019,7,17))
                .distanceToKindergarten(50)
                .distanceToPark(270)
                .distanceToRiver(540)
                .distanceToSchool(125)
                .distanceToShoppingCenters(130)
                .district("first")
                .isActive(true)
                .isConnectedToMedia(true)
                .isElevatorAvailable(false)
                .isGarageAvailable(true)
                .isParkingAvailable(false)
                .isPrimaryMarket(false)
                .numberOfApartments(50)
                .photosUrl("https://bighouse.com")
                .region("Lower Silesia")
                .street("Kosciuszki")
                .timeToBusStopMin(10)
                .timeToCityCenterMin(50)
                .buildingConstructionType("Concrete")
                .developerName(developerRepository.getOne(2L).getDeveloperName())
                .developer(developerRepository.getOne(2L))
                .build();
        buildingRepository.save(building1);
        buildingRepository.save(building2);
        buildingRepository.save(building3);
        buildingRepository.save(building4);

        log.debug("Saved building: {} and {} and {} and {}", building1, building2, building3, building4);
    }
}
