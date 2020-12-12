package projects.realestatemanager.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projects.realestatemanager.converter.ApartmentConverter;
import projects.realestatemanager.data.apartment.ApartmentSummary;
import projects.realestatemanager.domain.model.Apartment;
import projects.realestatemanager.domain.repository.ApartmentRepository;
import projects.realestatemanager.exception.ApartmentAlreadyExistExeption;
import projects.realestatemanager.web.command.CreateApartmentCommand;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ApartmentService {

    private final ApartmentRepository apartmentRepository;
    private final ApartmentConverter apartmentConverter;

    public List<ApartmentSummary> findByAllApartments(){
        log.debug("Get all apartments info");
        return apartmentRepository.findAll().stream()
                .map(apartmentConverter::toApartmentSummary)
                .collect(Collectors.toList());
    }

    public void add(@Valid CreateApartmentCommand createApartmentCommand) throws ApartmentAlreadyExistExeption {
        log.debug("Apartment data to be saved: {}", createApartmentCommand);
        Apartment apartmentToAdd = apartmentConverter.from(createApartmentCommand);
        log.debug("Converted apartment entity to add: {}", apartmentToAdd);
        if (apartmentRepository.existsByAreaAndAndRoomsNumberAndFloor(
                (int) apartmentToAdd.getArea(),
                apartmentToAdd.getRoomsNumber(),
                apartmentToAdd.getFloor())){
        log.debug("Trying to add existing apartment");
        throw new ApartmentAlreadyExistExeption(String.format(
                "Apartment with %s area, numbers of rooms %s number of floor %s is already exist in DB",
                apartmentToAdd.getArea(), apartmentToAdd.getRoomsNumber(), apartmentToAdd.getFloor()));

        }

        apartmentToAdd.setActive(true);
        apartmentToAdd.setCreationDate(LocalDate.now());
        apartmentRepository.save(apartmentToAdd);
        log.debug("Added apartment: {}", apartmentToAdd);

    }

}
