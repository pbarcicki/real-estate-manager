package projects.realestatemanager.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projects.realestatemanager.service.UserService;

@Controller
@RequestMapping("/clients")
@Slf4j @RequiredArgsConstructor
public class UserListController {

    private final UserService userService;

    @GetMapping
    public String getUserListPage(Model model){
        model.addAttribute("users", userService.findUsers());
        return "user/list";
    }
}
