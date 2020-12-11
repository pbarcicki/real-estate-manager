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

    //    todo rozwiązać problem z edycją dewelopera
    @PostMapping("/{id}")
    public String editDeveloperProfile(Model model,
                                       @Valid EditDeveloperCommand editDeveloperCommand,
                                       @PathVariable Long id,
                                       BindingResult bindingResult) {
        //todo obsługa błędów przez binding results!
        log.debug("Złapano id={}", id.toString());

        try {
            boolean success = developerService.editDeveloper(id, editDeveloperCommand);
            log.debug("UDANA ZMIANA DANYCH!");
            return "redirect:/" + id.toString();
        } catch (RuntimeException re) {
            log.warn(re.getLocalizedMessage());
            log.debug("Błąd przy edycji danych", re);
            bindingResult.rejectValue(null, null, "Wystąpił Błąd...");
        }
        return "redirect:/developer/list";
    }
}