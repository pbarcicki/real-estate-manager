package projects.realestatemanager.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import projects.realestatemanager.domain.service.ApartmentService;

@Controller
public class ApartmentController {

    @Autowired
    private ApartmentService apartmentService;

}
