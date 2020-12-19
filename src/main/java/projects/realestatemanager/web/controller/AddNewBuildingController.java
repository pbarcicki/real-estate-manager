package projects.realestatemanager.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projects.realestatemanager.data.developer.DeveloperSummary;
import projects.realestatemanager.exception.BuildingAlreadyExistsException;
import projects.realestatemanager.service.BuildingService;
import projects.realestatemanager.service.DeveloperService;
import projects.realestatemanager.web.command.CreateBuildingCommand;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/buildings")
@Slf4j
@RequiredArgsConstructor
public class AddNewBuildingController {

    private final BuildingService buildingService;
    private final DeveloperService developerService;

    @ModelAttribute("availableDevelopers")
    public List<DeveloperSummary> availableDevelopers() {
        return developerService.showAllDevelopers();
    }

    @GetMapping("/add")
    public String getAddBuildingPage(Model model) {
        model.addAttribute(new CreateBuildingCommand());
        return "building/add";
    }

    @PostMapping("/add")
    public String processAddBuilding(@Valid CreateBuildingCommand createBuildingCommand,
                                     BindingResult bindingResult) {
        log.debug("Data to create building");

        if (bindingResult.hasErrors()) {
            log.debug("Wrong input: {}", bindingResult.getAllErrors());
            return "building/add";
        }

        try {
            buildingService.add(createBuildingCommand);
            log.debug("Building added");
            return "redirect:/buildings/list";
        } catch (BuildingAlreadyExistsException baee) {
            bindingResult.rejectValue("city", null, "Building in this city with such address already exists");
            return "building/add";
        } catch (RuntimeException re) {
            bindingResult.rejectValue(null, null, "Error");
            return "building/add";
        }
    }

}
