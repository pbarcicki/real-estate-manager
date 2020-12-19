package projects.realestatemanager.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import projects.realestatemanager.domain.model.Building;
import projects.realestatemanager.domain.model.User;
import projects.realestatemanager.service.BuildingService;
import projects.realestatemanager.service.UserService;

@Controller
@RequestMapping("/buildings/list")
@Slf4j
@RequiredArgsConstructor
public class BuildingListController {

    private final BuildingService buildingService;
    private final UserService userService;

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

    @GetMapping("/fav")
    public String addBuildingToFavourites(@RequestParam(name = "buildingId") Long buildingId) {
        log.debug("Pobrano id budynku do dodania: id={}", buildingId);
        Building building = buildingService.findBuildingById(buildingId);
        log.debug("Budynek do dodania: {}", building);

        String loggedUSer = SecurityContextHolder.getContext().getAuthentication().getName();
        log.debug("zalogowany użytkownik: {}", loggedUSer);

        userService.addBuilding(loggedUSer, building);
        return "redirect:/buildings/list";
    }
}
