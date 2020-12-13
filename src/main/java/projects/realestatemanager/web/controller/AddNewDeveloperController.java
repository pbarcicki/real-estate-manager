package projects.realestatemanager.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projects.realestatemanager.exception.DeveloperAlreadyExistsException;
import projects.realestatemanager.service.DeveloperService;
import projects.realestatemanager.web.command.CreateDeveloperCommand;

import javax.validation.Valid;

@Controller
@RequestMapping("/developers/add")
@Slf4j
@RequiredArgsConstructor
public class AddNewDeveloperController {
    private final DeveloperService developerService;

    @GetMapping
    public String getAddDeveloperPage(Model model) {
        model.addAttribute(new CreateDeveloperCommand());
        return "developer/add";
    }

    @PostMapping
    public String processAddDeveloper(@Valid CreateDeveloperCommand createDeveloperCommand, BindingResult bindingResult) {
        log.debug("Dane DEWELOPERA do dodania: {}", createDeveloperCommand);
        if (bindingResult.hasErrors()) {
            log.debug("BŁĄD! Dane niepoprawne: {}", bindingResult.getAllErrors());
            return "developer/add";
        }

        try {
            Long id = developerService.createDeveloper(createDeveloperCommand);
            log.debug("Utworzono DEWELOPERA o id={}", id);
            return "redirect:/developers/list";
        } catch (DeveloperAlreadyExistsException daee) {
            bindingResult.rejectValue("developerName", null, "UWAGA! Deweloper o podobnej nazwie już istnieje...");
            return "developer/add";
        } catch (RuntimeException runtimeException) {
            bindingResult.reject(null, "UWAGA! Wystąpił błąd");
            return "developer/add";
        }
    }
}