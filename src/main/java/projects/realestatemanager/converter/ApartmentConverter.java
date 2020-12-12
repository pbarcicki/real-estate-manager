package projects.realestatemanager.converter;

import org.springframework.stereotype.Component;
import projects.realestatemanager.data.apartment.ApartmentSummary;
import projects.realestatemanager.domain.model.Apartment;
import projects.web.command.CreateApartmentCommand;

@Component
public class ApartmentConverter {

    public Apartment from(CreateApartmentCommand createApartmentCommand){
        return Apartment.builder()
                .floor(createApartmentCommand.getFloor())
                .onCorner(createApartmentCommand.isOnCorner())
                .area(createApartmentCommand.getArea())
                .roomsNumber(createApartmentCommand.getRoomsNumber())
                .typeOfKitchen(createApartmentCommand.getTypeOfKitchen())
                .price(createApartmentCommand.getPrice())
                .squareMeterPrice(createApartmentCommand.getSquareMeterPrice())
                .marketType(createApartmentCommand.getMarketType())
                .status(createApartmentCommand.getStatus())
                .exclusivity(createApartmentCommand.isExclusivity())
                .windowsDirection(createApartmentCommand.getWindowsDirection())
                .storageRoom(createApartmentCommand.isStorageRoom())
                .comment(createApartmentCommand.getComment())
                .build();
    }


    public ApartmentSummary toApartmentSummary(Apartment apartment){
        return ApartmentSummary.builder()
                .floor(apartment.getFloor())
                .onCorner(apartment.isOnCorner())
                .area(apartment.getArea())
                .roomsNumber(apartment.getRoomsNumber())
                .typeOfKitchen(apartment.getTypeOfKitchen())
                .price(apartment.getPrice())
                .squareMeterPrice(apartment.getSquareMeterPrice())
                .marketType(apartment.getMarketType())
                .status(apartment.getStatus())
                .exclusivity(apartment.isExclusivity())
                .windowsDirection(apartment.getWindowsDirection())
                .storageRoom(apartment.isStorageRoom())
                .comment(apartment.getComment())
                .build();
    }
}
