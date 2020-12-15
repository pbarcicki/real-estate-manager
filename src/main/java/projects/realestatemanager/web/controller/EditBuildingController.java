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
import projects.realestatemanager.exception.EntityDoesNotExistException;
import projects.realestatemanager.exception.EntityHasConnectionsException;
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
        return developerService.showAllDevelopers();
    }

    @GetMapping("/{id:[0-9]+}")
    public String getBuildingEditPage(Model model, @PathVariable Long id) {

        if (buildingRepository.existsById(id)) {
            model.addAttribute(new EditBuildingCommand());
            model.addAttribute("buildingEdit", buildingService.showBuildingById(id));
            return "building/edit";
        } else {
            return "redirect:/buildings/list";
        }

    }

    @PostMapping("/{id:[0-9]+}")
    public String processEditBuilding(@Valid EditBuildingCommand editBuildingCommand, BindingResult bindingResult) {
        Long id = editBuildingCommand.getId();
        log.debug("Developer to edit id: {}", id);

//        if (bindingResult.hasErrors()) {
//            log.debug("Wrong input: {}", bindingResult.getAllErrors());
//            return "building/edit";
//        }

        try {
            buildingService.editBuilding(editBuildingCommand);
            log.debug("Building successfully edited");
            return "redirect:/buildings/list";
        } catch (EntityDoesNotExistException bdnee)  {
            log.debug("Trying to edit not existing building");
            bindingResult.reject(null, "Trying to edit not existing building");
            return "building/edit";
        } catch (RuntimeException re) {
            log.debug("Error while saving edited building: {}", re);
            bindingResult.rejectValue("city", null, "Error while saving edited building!");
        }
        return ("redirect:/buildings/edit/" + id);
    }

    @PostMapping("/{id:[0-9]+}/delete")
    public String deleteBuilding(@PathVariable(value = "id") Long id){
        log.debug("Building id to delete: {}", id);
        try {
            buildingService.deleteById(id);
            return "redirect:/buildings/list";
        } catch (EntityDoesNotExistException ddnee) {
            log.warn(ddnee.getLocalizedMessage());
            log.error("Building with id {} does nor exist", id);
            return "redirect:/buildings/list";
        } catch (EntityHasConnectionsException ehce) {
            log.debug("Trying to edit not existing building");
            return "redirect:/buildings/list";
        } catch (RuntimeException re) {
            log.warn(re.getLocalizedMessage());
            log.error("Unknown error while deleting building", re);
            return "redirect:/buildings/list";
        }

    }

}
