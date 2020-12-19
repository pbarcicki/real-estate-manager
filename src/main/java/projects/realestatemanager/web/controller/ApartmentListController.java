package projects.realestatemanager.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import projects.realestatemanager.domain.model.Developer;
import projects.realestatemanager.service.ApartmentService;
import projects.realestatemanager.service.BuildingService;
import projects.realestatemanager.service.DeveloperService;

@Controller
@RequestMapping("/apartments/list")
@Slf4j
@RequiredArgsConstructor
public class ApartmentListController {

    private final ApartmentService apartmentService;
    private final BuildingService buildingService;
    private final DeveloperService developerService;

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
}