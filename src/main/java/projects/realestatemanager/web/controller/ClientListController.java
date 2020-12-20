package projects.realestatemanager.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import projects.realestatemanager.domain.model.Client;
import projects.realestatemanager.service.ClientService;
import projects.realestatemanager.service.UserService;

@Controller
@RequestMapping("/clients/list")
@Slf4j
@RequiredArgsConstructor
public class ClientListController {

    private final ClientService clientService;
    private final UserService userService;

    @GetMapping
    public String getClientListPage(Model model){
        model.addAttribute("clientsList", clientService.findClients());
        return "client/list";
    }

    @GetMapping("/fav")
    public String addClientToFavourites(@RequestParam(name = "clientId") Long clientId) {

        Client client = clientService.findClientById(clientId);

        String loggedUser = SecurityContextHolder.getContext().getAuthentication().getName();

        userService.addClient(loggedUser, client);

        return "redirect:/clients/list";
    }
}
