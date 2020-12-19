package projects.realestatemanager.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import projects.realestatemanager.domain.model.Building;
import projects.realestatemanager.service.BuildingService;
import projects.realestatemanager.service.UserService;

@Controller
@RequestMapping("/")
@Slf4j @RequiredArgsConstructor
public class HomePageController {

    private final BuildingService buildingService;
    private final UserService userService;

    @GetMapping
    public String homePage(Model model) {
        String loggedUser = SecurityContextHolder.getContext().getAuthentication().getName();
        log.debug("Użytkownik o nazwie={}", loggedUser);

        model.addAttribute("favouriteBuildings", buildingService.getUserFavouriteBuildings(userService.findUserByName(loggedUser)));

        return "/profile/home";
    }

    @GetMapping("del/fav/building")
    public String removeBuildingFromFavourites(@RequestParam(name = "id") Long buildingId) {
        String loggedUser = SecurityContextHolder.getContext().getAuthentication().getName();
        log.debug("Użytkownik o nazwie={}", loggedUser);

        Building building = buildingService.findBuildingById(buildingId);
        userService.removeBuilding(loggedUser, building);

        return "redirect:/";
    }

}
