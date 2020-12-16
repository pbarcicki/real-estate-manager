package projects.realestatemanager.web.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import projects.realestatemanager.domain.repository.ApartmentRepository;
import projects.realestatemanager.service.ApartmentService;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/search/results")
@RequiredArgsConstructor
public class ResultListController {

    private final ApartmentService apartmentService;
    private final ApartmentRepository apartmentRepository;

    @GetMapping("/{ids:id[?]+[0-9]+[&]*}")
    public String getSearchPage(Model model, @PathVariable (value = "ids") String ids) {
        List<Long> idList = new ArrayList();
        log.debug("Received ids in show controller: {}", ids);
        idList.add(1L);
        idList.add(2L);
        //todo parse variable string into is list

        model.addAttribute("apartmentsToShow", apartmentService.showByIds(idList));
        return "search/results";
    }
}
