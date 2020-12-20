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
                .view("Park")
                .area(61)
                .exclusivity(false)
                .marketType("Primary")
                .onCorner(false)
                .active(true)
                .photosUrl("https://abc.net.au")
                .creationDate(LocalDate.of(2020,3,23))
                .comment("Three bedrooms, a living room, two bathrooms and a open kitchen.")
                .floor(2)
                .price(350000)
                .pricePerSquareMeter((int)350000/61)
                .roomsNumber(6)
                .status("Free")
                .storageRoom(true)
                .typeOfKitchen("Annex")
                .windowsDirection("South")
                .building(buildingRepository.getOne(2L))
                .build();
        Apartment apartment2 = Apartment.builder()
                .building(buildingRepository.getOne(1L))
                .view("Sea")
                .area(35)
                .exclusivity(true)
                .marketType("Secondary")
                .onCorner(true)
                .active(true)
                .photosUrl("http://state.gov")
                .creationDate(LocalDate.of(2020,12,3))
                .comment("Small flat. It features two rooms, a kitchen, and a bathroom. It is located in a sunny and quiet neighbourhood in Wroclaw.")
                .floor(7)
                .price(550000)
                .pricePerSquareMeter((int)550000/35)
                .roomsNumber(4)
                .status("Reserved")
                .storageRoom(false)
                .typeOfKitchen("Studio")
                .windowsDirection("West")
                .build();
        Apartment apartment3 = Apartment.builder()
                .building(buildingRepository.getOne(3L))
                .view("Park")
                .area(100)
                .exclusivity(false)
                .marketType("To renovate")
                .onCorner(false)
                .active(true)
                .photosUrl("http://statksnjfd.gov")
                .creationDate(LocalDate.of(2010,12,3))
                .comment("Flat is on the second floor. It is quite small because there are only two rooms.")
                .floor(2)
                .price(100000)
                .pricePerSquareMeter((int)100000/100)
                .roomsNumber(2)
                .status("Check with developer")
                .storageRoom(false)
                .typeOfKitchen("Annex")
                .windowsDirection("North")
                .build();
        Apartment apartment4 = Apartment.builder()
                .building(buildingRepository.getOne(4L))
                .view("Main street")
                .area(100)
                .exclusivity(false)
                .marketType("Secondary")
                .onCorner(false)
                .active(true)
                .photosUrl("http://webpage.com")
                .creationDate(LocalDate.of(2019,2,6))
                .comment("The living room is fortunately quite big.")
                .floor(3)
                .price(1000000)
                .pricePerSquareMeter((int)1000000/100)
                .roomsNumber(4)
                .status("Free")
                .storageRoom(true)
                .typeOfKitchen("Studio")
                .windowsDirection("South")
                .build();
        Apartment apartment5 = Apartment.builder()
                .building(buildingRepository.getOne(1L))
                .view("City center")
                .area(100)
                .exclusivity(false)
                .marketType("Primary")
                .onCorner(true)
                .active(true)
                .photosUrl("http://photopage.com")
                .creationDate(LocalDate.of(2020,2,1))
                .comment("Our flat is situated in the city centre, which is a big asset. It is close to most schools, the post office and the main railway station. There is also a huge park and a supermarket in our neighbourhood. ")
                .floor(3)
                .price(1000000)
                .pricePerSquareMeter((int)1000000/100)
                .roomsNumber(4)
                .status("Reserved")
                .storageRoom(true)
                .typeOfKitchen("Studio")
                .windowsDirection("South")
                .build();
        Apartment apartment6 = Apartment.builder()
                .building(buildingRepository.getOne(2L))
                .view("Park")
                .area(50)
                .exclusivity(true)
                .marketType("Secondary")
                .onCorner(true)
                .active(true)
                .photosUrl("http://pageshots.com")
                .creationDate(LocalDate.of(2019,7,11))
                .comment("There are three bedrooms, a lovely kitchen, one bathroom and a balcony.")
                .floor(3)
                .price(1000000)
                .pricePerSquareMeter((int)1000000/50)
                .roomsNumber(4)
                .status("Reserved")
                .storageRoom(false)
                .typeOfKitchen("Annex")
                .windowsDirection("West")
                .build();
        Apartment apartment7 = Apartment.builder()
                .building(buildingRepository.getOne(3L))
                .view("Lake")
                .area(500)
                .exclusivity(true)
                .marketType("Primary")
                .onCorner(false)
                .active(true)
                .photosUrl("http://lakeshots.com")
                .creationDate(LocalDate.of(2018,4,11))
                .comment("We have even got a private parking.")
                .floor(4)
                .price(50000)
                .pricePerSquareMeter((int)50000/500)
                .roomsNumber(6)
                .status("Free")
                .storageRoom(true)
                .typeOfKitchen("Annex")
                .windowsDirection("North")
                .build();
        Apartment apartment8 = Apartment.builder()
                .building(buildingRepository.getOne(3L))
                .view("City center")
                .area(20)
                .exclusivity(false)
                .marketType("Secondary")
                .onCorner(true)
                .active(true)
                .photosUrl("http://centerphotos.com")
                .creationDate(LocalDate.of(2020,5,1))
                .comment("Big living room, dining room, kitchen, two bedrooms, one bathroom and a workroom.")
                .floor(6)
                .price(500000)
                .pricePerSquareMeter((int)500000/20)
                .roomsNumber(6)
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
