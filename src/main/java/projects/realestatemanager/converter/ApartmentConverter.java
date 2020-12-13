package projects.realestatemanager.converter;

import org.springframework.stereotype.Component;
import projects.realestatemanager.data.apartment.ApartmentSummary;
import projects.realestatemanager.domain.model.Apartment;
import projects.realestatemanager.web.command.CreateApartmentCommand;
import projects.realestatemanager.web.command.EditApartmentCommand;


@Component
public class ApartmentConverter {

    public Apartment from(CreateApartmentCommand createApartmentCommand){
        return Apartment.builder()
                .floor(createApartmentCommand.getFloor())
                .onCorner(createApartmentCommand.getOnCorner())
                .area(createApartmentCommand.getArea())
                .roomsNumber(createApartmentCommand.getRoomsNumber())
                .typeOfKitchen(createApartmentCommand.getTypeOfKitchen())
                .price(createApartmentCommand.getPrice())
                .squareMeterPrice(createApartmentCommand.getSquareMeterPrice())
                .marketType(createApartmentCommand.getMarketType())
                .status(createApartmentCommand.getStatus())
                .exclusivity(createApartmentCommand.getExclusivity())
                .windowsDirection(createApartmentCommand.getWindowsDirection())
                .storageRoom(createApartmentCommand.getStorageRoom())
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

    public Apartment from(EditApartmentCommand editApartmentCommand, Apartment apartment){
        apartment.setId(editApartmentCommand.getId());
        apartment.setFloor(editApartmentCommand.getFloor());
        apartment.setOnCorner(editApartmentCommand.getOnCorner());
        apartment.setArea(editApartmentCommand.getArea());
        apartment.setRoomsNumber(editApartmentCommand.getRoomsNumber());
        apartment.setTypeOfKitchen(editApartmentCommand.getTypeOfKitchen());
        apartment.setPrice(editApartmentCommand.getPrice());
        apartment.setSquareMeterPrice(editApartmentCommand.getSquareMeterPrice());
        apartment.setMarketType(editApartmentCommand.getMarketType());
        apartment.setStatus(editApartmentCommand.getStatus());
        apartment.setExclusivity(editApartmentCommand.getExclusivity());
        apartment.setWindowsDirection(editApartmentCommand.getWindowsDirection());
        apartment.setStorageRoom(editApartmentCommand.getStorageRoom());
        apartment.setComment(editApartmentCommand.getComment());

        return apartment;
    }
}
