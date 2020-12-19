package projects.realestatemanager.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projects.realestatemanager.data.developer.DeveloperSummary;
import projects.realestatemanager.exception.AllFieldsAreNullException;
import projects.realestatemanager.service.ApartmentService;
import projects.realestatemanager.service.BuildingService;
import projects.realestatemanager.service.DeveloperService;
import projects.realestatemanager.service.SearchService;
import projects.realestatemanager.web.command.SearchApartmentCommand;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private final DeveloperService developerService;
    private final SearchService searchService;

    @ModelAttribute("availableDevelopers")
    public List<DeveloperSummary> availableDevelopers() {
        return developerService.showAllDevelopers();
    }

    @GetMapping
    public String getSearchPage(Model model) {
        model.addAttribute(new SearchApartmentCommand());
        return "search/search";
    }

    @PostMapping()
    public String processSearch(@Valid SearchApartmentCommand searchApartmentCommand, BindingResult bindingResult) {
        log.debug("Search data: {}", searchApartmentCommand);

        if (bindingResult.hasErrors()) {
            log.debug("Wrong input: {}", bindingResult.getAllErrors());
            return "search/search";
        }


        try {
            String ids = searchService.search(searchApartmentCommand);
            log.debug("Search success!");
            return ("redirect:/search/results/"+ids);
        } catch (AllFieldsAreNullException nullFields) {
            bindingResult.rejectValue(null, null, "All fields are null");
            return "search/search";
        } catch (RuntimeException re) {
            log.warn("Unknown error while search");
            log.error(re.getLocalizedMessage());
            bindingResult.rejectValue(null, null, "Unknown error");
            return "search/search";
        }

    }
}
