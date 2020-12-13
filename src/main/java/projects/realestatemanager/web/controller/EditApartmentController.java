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
import projects.realestatemanager.exception.EntityDoesNotExistException;
import projects.realestatemanager.service.ApartmentService;
import projects.realestatemanager.web.command.EditApartmentCommand;

import javax.validation.Valid;

@Controller
@RequestMapping("apartments/edit")
@Slf4j
@RequiredArgsConstructor
public class EditApartmentController {

    private final ApartmentService apartmentService;
    private final ApartmentRepository apartmentRepository;

    @GetMapping("/{id:[0-9]+}")
    public String getApartmentEditPage(@PathVariable Long id, Model model) {
        model.addAttribute(new EditApartmentCommand());
        model.addAttribute("apartmentEdit", apartmentService.showApartmentById(id));
        return "apartment/edit";
    }

    @PostMapping("/{id:[0-9]+}")
    public String processEditApartment(@Valid EditApartmentCommand editApartmentCommand,
                                       BindingResult bindingResult) {
        Long id = editApartmentCommand.getId();

        try {
            apartmentService.editApartment(editApartmentCommand);
            log.debug("Apartment edited");
            return "redirect:/apartments/list";
        } catch (EntityDoesNotExistException ednee) {
            log.debug("Trying to edit not existing apartment");
            bindingResult.reject(null, "Trying to edit not existing building");
            return "apartment/edit";
        } catch (RuntimeException re) {
            log.debug("Error while saving edited apartment: {}", re);
            bindingResult.rejectValue("id", null, "Error while saving edited apartment");
        }
        return ("redirect:/apartments/edit/" + id);
    }
}
