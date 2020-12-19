package projects.realestatemanager.loader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import projects.realestatemanager.domain.model.Apartment;
import projects.realestatemanager.domain.repository.ApartmentRepository;
import projects.realestatemanager.domain.repository.BuildingRepository;
import projects.realestatemanager.enums.ApartmentStatus;
import projects.realestatemanager.enums.ApartmentTypeOfMarket;
import projects.realestatemanager.enums.KitchenType;

import java.time.LocalDate;

@Component
@Profile("heroku")
@Slf4j
@RequiredArgsConstructor
public class ApartmentDataLoader implements DataLoader{

    private final ApartmentRepository apartmentRepository;
    private final BuildingRepository buildingRepository;

    public int getOrder(){
        return Integer.MIN_VALUE + 2;
    }

    @Transactional
    public void loadData(){
        Apartment apartment1 = Apartment.builder()
                .pricePerSquareMeter(1000)
                .view("Street")
                .area(61)
                .exclusivity(false)
                .marketType("Primary")
                .onCorner(false)
                .active(true)
                .photosUrl("https://abc.net.au")
                .creationDate(LocalDate.of(2020,3,23))
                .comment("morbi ut odio cras mi pede malesuada in imperdiet et commodo vulputate justo in blandit ultrices enim lorem")
                .floor(2)
                .price(350000)
                .roomsNumber(3)
                .status("Free")
                .storageRoom(true)
                .typeOfKitchen("Annex")
                .windowsDirection("South")
                .building(buildingRepository.getOne(2L))
                .build();
        Apartment apartment2 = Apartment.builder()
                .pricePerSquareMeter(1500)
                .building(buildingRepository.getOne(1L))
                .view("Sea")
                .area(121)
                .exclusivity(true)
                .marketType("Secondary")
                .onCorner(true)
                .active(true)
                .photosUrl("http://state.gov") 
                .creationDate(LocalDate.of(2020,12,3))
                .comment("feugiat non pretium quis lectus suspendisse potenti in eleifend quam a odio in hac habitasse platea dictumst")
                .floor(7)
                .price(550000)
                .roomsNumber(5)
                .status("Reserved")
                .storageRoom(false)
                .typeOfKitchen("Studio")
                .windowsDirection("West")
                .build();
        apartmentRepository.save(apartment1);
        apartmentRepository.save(apartment2);
        log.debug("Saved apartament: {} and {}", apartment1, apartment2);
    }

}
