package projects.realestatemanager.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import projects.realestatemanager.domain.model.Apartment;
import org.springframework.web.bind.annotation.RequestParam;
import projects.realestatemanager.domain.model.Apartment;
import projects.realestatemanager.domain.model.Developer;
import projects.realestatemanager.service.ApartmentService;
import projects.realestatemanager.service.BuildingService;
import projects.realestatemanager.service.DeveloperService;
import projects.realestatemanager.service.UserService;

@Controller
@RequestMapping("/apartments/list")
@Slf4j
@RequiredArgsConstructor
public class ApartmentListController {

    private final ApartmentService apartmentService;
    private final BuildingService buildingService;
    private final DeveloperService developerService;

    private final UserService userService;

    @GetMapping()
    public String getApartmentListPage(Model model){
        model.addAttribute("apartments", apartmentService.findAllApartments());
        model.addAttribute("buildings", buildingService.findAllBuildings());
        model.addAttribute("developers", developerService.showAllDevelopers());
        return "apartment/list";
    }

    @GetMapping("/details/{id:[0-9]+}")
    public String getBuildingDetailsPage(Model model, @PathVariable Long id) {
        model.addAttribute("apartment", apartmentService.findApartmentById(id));
        return ("apartment/details");
    }

    @GetMapping("/{idString:^[b][0-9].*$}")
    public String getBuildingRelatedApartmentsPage(Model model, @PathVariable String idString) {
        log.debug("received building id: {}", idString);
        Long id = Long.parseLong(idString.substring(1));
        log.debug("Parsed building id: {}", id);

        model.addAttribute("apartments", apartmentService.findApartmentByBuildingId(id));
        return ("apartment/list");
    }

    @GetMapping("/fav")
    public String addApartmentToFavourites(@RequestParam(name = "apartmentId") Long apartmentId) {

        Apartment apartment = apartmentService.findApartmentById(apartmentId);

        String loggedUser = SecurityContextHolder.getContext().getAuthentication().getName();

        userService.addApartment(loggedUser, apartment);
        return "redirect:/apartments/list";

    }
}