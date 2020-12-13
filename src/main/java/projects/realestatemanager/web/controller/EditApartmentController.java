package projects.realestatemanager.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projects.realestatemanager.domain.model.Apartment;
import projects.realestatemanager.domain.repository.ApartmentRepository;
import projects.realestatemanager.service.ApartmentService;
import projects.realestatemanager.web.command.EditApartmentCommand;

import javax.validation.Valid;

@Controller
@RequestMapping
@Slf4j
@RequiredArgsConstructor
public class EditApartmentController {

private final ApartmentService apartmentService;
private final ApartmentRepository apartmentRepository;

@GetMapping("/{id:[0-9]+}")
    public String getApartmentEditPage(@PathVariable Long id, Model model){
    Apartment apartmentToEdit = apartmentRepository.getOne(id);
    model.addAttribute(new EditApartmentCommand());
    model.addAttribute("apartmentEdit", apartmentService.showApartmentById(id));
    return "apartment/edit";
}
@PostMapping ("/{id:[0-9]+}")
    public String processEditApartment(@Valid EditApartmentCommand editApartmentCommand,
                                       BindingResult bindingResult){
    try{
        apartmentService.editApartment(editApartmentCommand);
        log.debug("Apartment edited");
        return "redirected:/apartments/list";
    }catch (RuntimeException re){
        log.debug("Error while saving edited apartment: {}", re);
        bindingResult.rejectValue("id", null, "Error while saving edited apartment");
        return "apartment/list";
    }
}
}
