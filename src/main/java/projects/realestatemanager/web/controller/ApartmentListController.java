package projects.realestatemanager.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projects.realestatemanager.service.ApartmentService;
import projects.realestatemanager.service.BuildingService;

@Controller
@RequestMapping("/apartments/list")
@Slf4j
@RequiredArgsConstructor
public class ApartmentListController {

    private final ApartmentService apartmentService;
    private final BuildingService buildingService;

    @GetMapping()
    public String getApartmentListPage(Model model){
        model.addAttribute("apartments", apartmentService.findByAllApartments());
        model.addAttribute("buildings", buildingService.findAllBuildings());
        return "apartment/list";
    }
}
