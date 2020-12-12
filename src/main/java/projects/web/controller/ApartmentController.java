package projects.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projects.web.command.CreateApartmentCommand;

import javax.validation.Valid;

@Controller
@RequestMapping("/apartments")
@Slf4j
@RequiredArgsConstructor

public class ApartmentController {

    private final ApartmentService apartmentService;

    @GetMapping("/list")
    public String getApartmentListPage(Model model) {
        model.addAttribute(new CreateApartmentCommand());
        return "apartment/add";
    }

    @PostMapping("/add")
    public String processAddApartment(@Valid CreateApartmentCommand createApartmentCommand, BindingResult bindingResult) {
        log.debug("Data to create apartment");
        if (bindingResult.hasErrors()) {
            log.debug("Wrong input: {}", bindingResult.getAllErrors());
            return "apartment/add";

        }
        try{
            apartmentService.add(createApartmentCommand);
            log.debug("Apartment is added");
            return "apartment/list";
        }catch
        (RuntimeException re){
            bindingResult.rejectValue(null, null, "Error");
            return "apartment/add";
        }
    }

}
