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
import projects.realestatemanager.domain.model.Developer;
import projects.realestatemanager.domain.repository.DeveloperRepository;
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
    public String showDeveloperEdit(Model model, @PathVariable Long id) {
        Developer developer = developerRepository.getOne(id);

        model.addAttribute(new EditDeveloperCommand());
        model.addAttribute("developerEdit", developerService.showDeveloper(id));

        return "developer/edit";
    }

    @PostMapping("/{id:[0-9]+}")
    public String editDeveloper(@Valid EditDeveloperCommand editDeveloperCommand, BindingResult bindingResult) {
        Long id = editDeveloperCommand.getId();

        try {
            boolean success = developerService.edit(editDeveloperCommand);
            log.debug("UDANA ZMIANA DANYCH!");
            return "redirect:/developers/list";
        } catch (RuntimeException re) {
            log.warn(re.getLocalizedMessage());
            log.error("Błąd przy edycji danych", re);
            bindingResult.rejectValue("errors", null, "Wystąpił nieznany błąd przy edycji DEWELOPERA");
        }
        return ("redirect:/developers/edit/" + id);

    }
}