package projects.realestatemanager.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projects.realestatemanager.service.BuildingService;
import projects.realestatemanager.web.command.CreateBuildingCommand;

import javax.validation.Valid;

@Controller
@RequestMapping("/buildings")
@Slf4j
@RequiredArgsConstructor
public class BuildingController {

    private final BuildingService buildingService;

    @GetMapping("/list")
    public String getBuildingsListPage(Model model) {
        model.addAttribute(buildingService.findAllBuildings());
        return "building/list";
    }

    @GetMapping("/add")
    public String processAddBuilding(@Valid CreateBuildingCommand createBuildingCommand, BindingResult bindingResult) {
        log.debug("Data to create building");
        if(bindingResult.hasErrors()) {
            log.debug("Wrong input: {}", bindingResult.getAllErrors());
            return "building/add";
        }

        try {
            buildingService.add(createBuildingCommand);
            log.debug("Building added");
            return "building/list";
        } catch (RuntimeException re) {
            bindingResult.rejectValue(null, null, "Error");
            return "building/add";
        }
    }

}
