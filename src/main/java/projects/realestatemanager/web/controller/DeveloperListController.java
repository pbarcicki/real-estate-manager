package projects.realestatemanager.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import projects.realestatemanager.service.DeveloperService;

@Controller
@RequestMapping("/developers/list")
@Slf4j
@RequiredArgsConstructor
public class DeveloperListController {
    private final DeveloperService developerService;

    @GetMapping
    public String getDevelopersListPage(Model model) {
        model.addAttribute("developersList", developerService.showAllDevelopers());
        return "developer/list";
    }

    @GetMapping("/details/{id:[0-9]+}")
    public String getBuildingDetailsPage(Model model, @PathVariable Long id) {
        model.addAttribute("developer", developerService.findDeveloperById(id));
        return ("developer/details");
    }
}
