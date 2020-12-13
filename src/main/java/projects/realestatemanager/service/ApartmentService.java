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
import projects.realestatemanager.exception.ApartmentNoExistingException;
import projects.realestatemanager.web.command.CreateApartmentCommand;
import projects.realestatemanager.web.command.EditApartmentCommand;


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

    public void add(@Valid CreateApartmentCommand createApartmentCommand){
        log.debug("Apartment data to be saved: {}", createApartmentCommand);
        Apartment apartmentToAdd = apartmentConverter.from(createApartmentCommand);
        log.debug("Converted apartment entity to add: {}", apartmentToAdd);
        if (apartmentRepository.existsById(apartmentToAdd.getId()){
                Long id;
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

    public Apartment showApartmentById(Long id) {
    log.debug("Apartment id to find in DB: {}", id);
    CreateApartmentCommand apartmentToEdit = apartmentRepository.existsById(Long id);
    log.debug("Recived apartment to edit: {}", apartmentToEdit);
    if (!apartmentRepository.existsById(id)){
        log.debug("Trying to edit no existing apartment");
        throw new ApartmentNoExistingException(String.format("Apartment with id %s isn't existing", id));
    }
    return apartmentConverter.from(apartmentToEdit);
    }

    public boolean editApartment(EditApartmentCommand editApartmentCommand) {
        Long id = editApartmentCommand.getId();
        if(!apartmentRepository.existsById(id)){
            log.debug("Trying to edit no existing apartment");
            throw new ApartmentNoExistingException(String.format("Apartment with id %s isn't existing", id));

        }
        Apartment apartmentToEdit =  apartmentRepository.existsById(Long id);
        log.debug("Apartment to edit: {}", apartmentToEdit);
        apartmentToEdit = apartmentConverter.from(editApartmentCommand, apartmentToEdit);
        log.debug("Apartment edited: {}", apartmentToEdit);

        return true;
    }
}
