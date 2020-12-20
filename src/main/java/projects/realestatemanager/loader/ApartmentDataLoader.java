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
        Apartment apartment3 = Apartment.builder()
                .pricePerSquareMeter(2000)
                .building(buildingRepository.getOne(3L))
                .view("Street")
                .area(100)
                .exclusivity(false)
                .marketType("Primary")
                .onCorner(false)
                .active(true)
                .photosUrl("http://statksnjfd.gov")
                .creationDate(LocalDate.of(2010,12,3))
                .comment("hac habitasse platea dictumst")
                .floor(5)
                .price(100000)
                .roomsNumber(1)
                .status("Check with developer")
                .storageRoom(false)
                .typeOfKitchen("Annex")
                .windowsDirection("North")
                .build();
        Apartment apartment4 = Apartment.builder()
                .pricePerSquareMeter(2000)
                .building(buildingRepository.getOne(4L))
                .view("Street")
                .area(100)
                .exclusivity(false)
                .marketType("Secondary")
                .onCorner(false)
                .active(true)
                .photosUrl("http://webpage.com")
                .creationDate(LocalDate.of(2019,2,6))
                .comment("hac habitasse platea dictumst")
                .floor(3)
                .price(1000000)
                .roomsNumber(4)
                .status("Free")
                .storageRoom(true)
                .typeOfKitchen("Studio")
                .windowsDirection("South")
                .build();
        Apartment apartment5 = Apartment.builder()
                .pricePerSquareMeter(2000)
                .building(buildingRepository.getOne(1L))
                .view("Street")
                .area(100)
                .exclusivity(false)
                .marketType("Primary")
                .onCorner(true)
                .active(true)
                .photosUrl("http://photopage.com")
                .creationDate(LocalDate.of(2020,2,1))
                .comment("hac habitasse bla bla platea dictumst")
                .floor(3)
                .price(1000000)
                .roomsNumber(4)
                .status("Reserved")
                .storageRoom(true)
                .typeOfKitchen("Studio")
                .windowsDirection("South")
                .build();
        Apartment apartment6 = Apartment.builder()
                .pricePerSquareMeter(500)
                .building(buildingRepository.getOne(2L))
                .view("Park")
                .area(50)
                .exclusivity(true)
                .marketType("Secondary")
                .onCorner(true)
                .active(true)
                .photosUrl("http://pageshots.com")
                .creationDate(LocalDate.of(2019,7,11))
                .comment("hac habitasse bla bla platea dictumst")
                .floor(3)
                .price(1000000)
                .roomsNumber(4)
                .status("Reserved")
                .storageRoom(false)
                .typeOfKitchen("Annex")
                .windowsDirection("West")
                .build();
        Apartment apartment7 = Apartment.builder()
                .pricePerSquareMeter(1400)
                .building(buildingRepository.getOne(3L))
                .view("Lake")
                .area(500)
                .exclusivity(true)
                .marketType("Primary")
                .onCorner(false)
                .active(true)
                .photosUrl("http://lakeshots.com")
                .creationDate(LocalDate.of(2018,4,11))
                .comment("hac comment habitasse bla bla platea dictumst")
                .floor(4)
                .price(50000)
                .roomsNumber(6)
                .status("Free")
                .storageRoom(true)
                .typeOfKitchen("Annex")
                .windowsDirection("North")
                .build();
        Apartment apartment8 = Apartment.builder()
                .pricePerSquareMeter(300)
                .building(buildingRepository.getOne(3L))
                .view("City center")
                .area(20)
                .exclusivity(false)
                .marketType("Secondary")
                .onCorner(true)
                .active(true)
                .photosUrl("http://centerphotos.com")
                .creationDate(LocalDate.of(2020,5,1))
                .comment("hac comment lots habitasse bla bla platea dictumst")
                .floor(6)
                .price(500000)
                .roomsNumber(2)
                .status("Check with developer")
                .storageRoom(true)
                .typeOfKitchen("Studio")
                .windowsDirection("South")
                .build();
        apartmentRepository.save(apartment1);
        apartmentRepository.save(apartment2);
        apartmentRepository.save(apartment3);
        apartmentRepository.save(apartment4);
        apartmentRepository.save(apartment5);
        apartmentRepository.save(apartment6);
        apartmentRepository.save(apartment7);
        apartmentRepository.save(apartment8);
        log.debug("Saved apartments: {} and {} and {} and {} and {} and {} and {} and {}"
                , apartment1, apartment2, apartment3, apartment4, apartment5, apartment6, apartment7,
                apartment8);
    }

}
