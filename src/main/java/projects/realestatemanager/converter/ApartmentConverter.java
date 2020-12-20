package projects.realestatemanager.converter;

import org.springframework.stereotype.Component;
import projects.realestatemanager.data.apartment.ApartmentSummary;
import projects.realestatemanager.domain.model.Apartment;
import projects.realestatemanager.domain.model.Building;
import projects.realestatemanager.domain.model.Developer;
import projects.realestatemanager.web.command.CreateApartmentCommand;
import projects.realestatemanager.web.command.EditApartmentCommand;


@Component
public class ApartmentConverter {

    public Apartment from(CreateApartmentCommand createApartmentCommand, Building building){
        return Apartment.builder()
                .building(building)
                .floor(createApartmentCommand.getFloor())
                .onCorner(createApartmentCommand.getOnCorner())
                .area(createApartmentCommand.getArea())
                .roomsNumber(createApartmentCommand.getRoomsNumber())
                .typeOfKitchen(createApartmentCommand.getTypeOfKitchen())
                .price(createApartmentCommand.getPrice())
                .pricePerSquareMeter(createApartmentCommand.getPricePerSquareMeter())
                .marketType(createApartmentCommand.getMarketType())
                .status(createApartmentCommand.getStatus())
                .exclusivity(createApartmentCommand.getExclusivity())
                .windowsDirection(createApartmentCommand.getWindowsDirection())
                .view(createApartmentCommand.getView())
                .storageRoom(createApartmentCommand.getStorageRoom())
                .comment(createApartmentCommand.getComment())
                .photosUrl(createApartmentCommand.getPhotosUrl())
                .build();
    }


    public ApartmentSummary from(Apartment apartment){
        return ApartmentSummary.builder()
                .id((apartment.getId()))
                .floor(apartment.getFloor())
                .onCorner(apartment.getOnCorner())
                .area(apartment.getArea())
                .roomsNumber(apartment.getRoomsNumber())
                .typeOfKitchen(apartment.getTypeOfKitchen())
                .price(apartment.getPrice())
                .pricePerSquareMeter(apartment.getPricePerSquareMeter())
                .marketType(apartment.getMarketType())
                .status(apartment.getStatus())
                .exclusivity(apartment.getExclusivity())
                .windowsDirection(apartment.getWindowsDirection())
                .view(apartment.getView())
                .storageRoom(apartment.getStorageRoom())
                .comment(apartment.getComment())
                .active(apartment.getActive())
                .creationDate(apartment.getCreationDate())
                .photosUrl(apartment.getPhotosUrl())
                .build();
    }

    public Apartment from(EditApartmentCommand editApartmentCommand, Apartment apartment){
        apartment.setFloor(editApartmentCommand.getFloor());
        apartment.setOnCorner(editApartmentCommand.getOnCorner());
        apartment.setArea(editApartmentCommand.getArea());
        apartment.setRoomsNumber(editApartmentCommand.getRoomsNumber());
        apartment.setTypeOfKitchen(editApartmentCommand.getTypeOfKitchen());
        apartment.setPrice(editApartmentCommand.getPrice());
        apartment.setPricePerSquareMeter(editApartmentCommand.getPricePerSquareMeter());
        apartment.setMarketType(editApartmentCommand.getMarketType());
        apartment.setStatus(editApartmentCommand.getStatus());
        apartment.setExclusivity(editApartmentCommand.getExclusivity());
        apartment.setWindowsDirection(editApartmentCommand.getWindowsDirection());
        apartment.setView(editApartmentCommand.getView());
        apartment.setStorageRoom(editApartmentCommand.getStorageRoom());
        apartment.setComment(editApartmentCommand.getComment());
        apartment.setActive(editApartmentCommand.getActive());
        apartment.setPhotosUrl(editApartmentCommand.getPhotosUrl());

        return apartment;
    }

}