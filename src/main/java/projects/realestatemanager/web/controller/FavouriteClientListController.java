package projects.realestatemanager.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projects.realestatemanager.service.ClientService;

@Controller
@RequestMapping("/clients/favouriteList")
@Slf4j
@RequiredArgsConstructor
public class FavouriteClientListController {

    private final ClientService clientService;

    @GetMapping
    public String getFavouriteClientListPage(Model model){
        model.addAttribute("favouriteClientsList",
                clientService.findFavouriteClients());
        return "client/favouriteList";
    }
}
