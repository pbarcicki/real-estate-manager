package projects.realestatemanager.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
