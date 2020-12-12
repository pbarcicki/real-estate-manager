package projects.realestatemanager.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projects.realestatemanager.service.ClientService;

@Controller
@RequestMapping("/clients/list")
@Slf4j
@RequiredArgsConstructor
public class ClientListController {

    private final ClientService clientService;

    @GetMapping
    public String getClientListPage(Model model){
        model.addAttribute("clientsList", clientService.findClients());
        return "client/list";
    }
}
