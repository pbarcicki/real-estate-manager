package projects.realestatemanager.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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


}
