package projects.realestatemanager.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projects.realestatemanager.exception.ApartmentAlreadyExistExeption;
import projects.realestatemanager.service.ApartmentService;
import projects.realestatemanager.web.command.CreateApartmentCommand;
import javax.validation.Valid;

@Controller
@RequestMapping("/apartments/add")
@Slf4j
@RequiredArgsConstructor
public class AddNewApartmentController {

    private final ApartmentService apartmentService;
//    private final DeveloperService developerService;
//
//    @ModelAttribute("availableDeveloper")
//    public List<DeveloperSummary> availableDevelopers() {
//        return developerService.showAllDevelopers();
//    }

    @GetMapping
    public String getAddApartmentPage(Model model) {
        model.addAttribute(new CreateApartmentCommand());
        return "apartment/add";
    }

    @PostMapping
    public String processAddApartment(@Valid CreateApartmentCommand createApartmentCommand,
                                      BindingResult bindingResult) {
        log.debug("Data to create apartment: {}", createApartmentCommand);

        if (bindingResult.hasErrors()) {
            log.debug("Wrong input: {}", bindingResult.getAllErrors());
            return "apartment/add";
        }
        try {
            apartmentService.add(createApartmentCommand);
            log.debug("Apartment added");
            return "redirect:/apartments/list";
        } catch (ApartmentAlreadyExistExeption apaee) {
            bindingResult.rejectValue(null, null, "Apartment with this id already exist");
            return "apartment/add";
        } catch (RuntimeException re) {
            bindingResult.rejectValue(null, null, "Error");
            return "apartment/add";
        }
    }

}