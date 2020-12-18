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
import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/search/results")
@RequiredArgsConstructor
public class ResultListController {

    private final ApartmentService apartmentService;
    private final ApartmentRepository apartmentRepository;

    //todo regex
    @GetMapping("/{ids:^[0-9].*[0-9]$}")
    public String getSearchPage(@PathVariable (value = "ids") String ids, Model model) {
        log.debug("Received ids in show controller: {}", ids);

        List<Long> idList = new ArrayList<>();

        String[] idsArray = ids.split("[+]");
        for (int i = 0; i < idsArray.length; i++) {
            idList.add(Long.parseLong(idsArray[i]));
        }

        log.debug("Received list of ids: {}", idList.size());

        model.addAttribute("apartmentsToShow", apartmentService.showByIds(idList));
        return "search/results";
    }
}
