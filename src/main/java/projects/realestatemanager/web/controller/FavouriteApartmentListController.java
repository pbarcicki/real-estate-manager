package projects.realestatemanager.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projects.realestatemanager.service.ApartmentService;

@Controller
@RequestMapping("/apartments/favouriteList")
@Slf4j
@RequiredArgsConstructor
public class FavouriteApartmentListController {

    private final ApartmentService apartmentService;

    @GetMapping
    public String getFavouriteApartmentListPage(Model model){
        model.addAttribute("favouriteApartmentsList",
                apartmentService.findFavouriteApartments());
        return "apartment/favouriteList";
    }
}
