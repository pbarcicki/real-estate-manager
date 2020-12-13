package projects.realestatemanager.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projects.realestatemanager.data.developer.DeveloperSummary;
import projects.realestatemanager.exception.ApartmentAlreadyExistExeption;
import projects.realestatemanager.service.ApartmentService;
import projects.realestatemanager.service.DeveloperService;
import projects.realestatemanager.web.command.CreateApartmentCommand;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/apartments")
@Slf4j
@RequiredArgsConstructor

public class AddApartmentController {

    private final ApartmentService apartmentService;
    private final DeveloperService developerService;

    @ModelAttribute("availableDeveloper")
    public List<DeveloperSummary> availableDevelopers(){
        return developerService.showAllDevelopers();

    }
    @PostMapping("/add")
    public String procecessAddApartment(@Valid CreateApartmentCommand createApartmentCommand,
                                        BindingResult bindingResult){
        log.debug("Data to create apartment");
        if (bindingResult.hasErrors()){
            log.debug("Wrong input: {}", bindingResult.getAllErrors());
            return "apartment/add";
        }
        try{
            apartmentService.add(createApartmentCommand);
            log.debug("Apartment added");
            return "redirected:/apartments/list";
        }catch(ApartmentAlreadyExistExeption apaee){
            bindingResult.rejectValue("id", null, "Apartment with this id already exist");
            return "apartment/add";
        }catch (RuntimeException re){
            bindingResult.rejectValue(null, null, "Error");
            return "apartment/add";
        }
    }

}
