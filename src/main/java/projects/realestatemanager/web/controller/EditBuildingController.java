package projects.realestatemanager.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import projects.realestatemanager.data.developer.DeveloperSummary;
import projects.realestatemanager.domain.model.Building;
import projects.realestatemanager.domain.repository.BuildingRepository;
import projects.realestatemanager.exception.BuildingDoesNotExistException;
import projects.realestatemanager.service.BuildingService;
import projects.realestatemanager.service.DeveloperService;
import projects.realestatemanager.web.command.EditBuildingCommand;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("buildings/edit")
@Slf4j
@RequiredArgsConstructor
public class EditBuildingController {

    private final BuildingService buildingService;
    private final DeveloperService developerService;
    private final BuildingRepository buildingRepository;


    @ModelAttribute("availableDevelopers")
    public List<DeveloperSummary> availableDevelopers() {
        return developerService.showAllDevelopers(); //todo getAllDevelopers które wyciąga listę developerów z dalszą konwertacją na summary
    }

    @GetMapping("/{id:[0-9]+}")
    public String getBuildingEditPage(@PathVariable Long id, Model model) {
        Building buildingToEdit = buildingRepository.getOne(id);

        model.addAttribute(new EditBuildingCommand());
        model.addAttribute("buildingEdit", buildingService.showBuildingById(id));
        return "building/edit";
    }

    @PostMapping("/{id:[0-9]+}")
    public String processEditBuilding(@Valid EditBuildingCommand editBuildingCommand, BindingResult bindingResult) {

        try {
            buildingService.editBuilding(editBuildingCommand);
            log.debug("Building successfully edited");
            return "redirect:/buildings/list";
        } catch (BuildingDoesNotExistException bdnee)  {
            log.debug("Trying to edit not existing building");
            bindingResult.rejectValue("city", null, "Trying to edit not existing building");
            return "building/list";
        } catch (RuntimeException re) {
            log.debug("Error while saving edited building: {}", re);
            bindingResult.rejectValue("city", null, "Error while saving edited building!");
            return "building/list";
        }
    }

}
