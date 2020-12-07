package projects.realestatemanager.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import projects.realestatemanager.domain.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

}
