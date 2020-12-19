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
import projects.realestatemanager.domain.repository.DeveloperRepository;
import projects.realestatemanager.exception.EntityDoesNotExistException;
import projects.realestatemanager.service.DeveloperService;
import projects.realestatemanager.web.command.EditDeveloperCommand;

import javax.validation.Valid;

@Controller
@RequestMapping("/developers/edit")
@Slf4j
@RequiredArgsConstructor
public class EditDeveloperController {
    private final DeveloperService developerService;
    private final DeveloperRepository developerRepository;

    @GetMapping("/{id:[0-9]+}")
    public String showDeveloperEdit(
            Model model,
            @PathVariable Long id) {

        if (developerRepository.existsById(id)) {
            model.addAttribute(new EditDeveloperCommand());
            model.addAttribute("developerEdit", developerService.showDeveloper(id));
            return "developer/edit";
        } else {
            return "redirect:/developers/list";
        }
    }

    @PostMapping("/{id:[0-9]+}")
    public String editDeveloper(
            @Valid EditDeveloperCommand editDeveloperCommand) {

        Long id = editDeveloperCommand.getId();
        log.debug("id DEWELOPERA do edycji = {}", id);
        try {
            boolean success = developerService.edit(editDeveloperCommand);
            log.debug("DEWELOPER od id={} został poprawnie zmodyfikowany", id);
            return "redirect:/developers/list";
        } catch (RuntimeException re) {
            log.warn(re.getLocalizedMessage());
            log.error("Nieznany błąd przy edycji danych DEWELOPERA", re);
        }
        return ("redirect:/developers/edit/" + id);

    }

    @PostMapping("/{id:[0-9]+}/delete")
    public String deleteDeveloper(@PathVariable(value = "id") Long id) {
        log.debug("Pobrano id={} DEWELOPERA do usunięcia", id);
        try {
            developerService.delete(id);
            return "redirect:/developers/list";
        } catch (EntityDoesNotExistException ddnee) {
            log.warn(ddnee.getLocalizedMessage());
            log.error("DEWELOPER od id={} nie istnieje! Nie ma kogo usunąć...", id);
            return "redirect:/developers/list";
        } catch (RuntimeException re) {
            log.warn(re.getLocalizedMessage());
            log.error("Nieznany błąd przy usuwaniu DEWELOPERA", re);
            return "redirect:/developers/list";
        }
    }
}