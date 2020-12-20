package projects.realestatemanager.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import projects.realestatemanager.service.BuildingService;

@Controller
@RequestMapping("/buildings/list")
@Slf4j
@RequiredArgsConstructor
public class BuildingListController {

    private final BuildingService buildingService;

    @GetMapping()
    public String getBuildingsListPage(Model model) {
        model.addAttribute("buildings", buildingService.findAllBuildings());
        return "building/list";
    }

    @GetMapping("/details/{id:[0-9]+}")
    public String getBuildingDetailsPage(Model model, @PathVariable Long id) {
        model.addAttribute("building", buildingService.findBuildingById(id));
        return ("building/details");
    }

    @GetMapping("/{idString:^[d][0-9].*$}")
    public String getDeveloperRelatedBuildingsPage(Model model, @PathVariable String idString) {
        log.debug("received developer id: {}", idString);
        Long id = Long.parseLong(idString.substring(1));
        log.debug("Parsed developer id: {}", id);

        model.addAttribute("buildings", buildingService.findBuildingDeveloperId(id));
        return ("building/list");
    }


}
