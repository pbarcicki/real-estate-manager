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
import projects.realestatemanager.exception.EntityHasConnectionsException;
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
        if(apartmentRepository.existsById(id)){
            model.addAttribute(new EditApartmentCommand());
            model.addAttribute("apartmentEdit", apartmentService.showApartmentById(id));
            return "apartment/edit";
        }else{
            return "redirect:/apartments/list";
        }

    }

    @PostMapping("/{id:[0-9]+}")
    public String processEditApartment(@Valid EditApartmentCommand editApartmentCommand,
                                       BindingResult bindingResult) {
        Long id = editApartmentCommand.getId();
        log.debug("Apartment to edit id: {}", id);
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
    @PostMapping("/{id:[0-9]+}/delete")
    public String deleteApartment(@PathVariable(value = "id") Long id) {
        log.debug("Apartment id to delete: {}", id);
        try {
            apartmentService.delete(id);
            return "redirect:/apartments/list";
        } catch (EntityDoesNotExistException ddnee) {
            log.warn(ddnee.getLocalizedMessage());
            log.error("Apartment with id {} does nor exist", id);
            return "redirect:/apartments/list";
        } catch (EntityHasConnectionsException ehce) {
            log.debug("Trying to edit not existing apartment");
            return "redirect:/apartments/list";
        } catch (RuntimeException re) {
            log.warn(re.getLocalizedMessage());
            log.error("Unknown error while deleting apartment", re);
            return "redirect:/apartments/list";
        }
    }
}