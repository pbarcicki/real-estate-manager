package projects.realestatemanager.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projects.realestatemanager.service.BuildingService;

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

}
