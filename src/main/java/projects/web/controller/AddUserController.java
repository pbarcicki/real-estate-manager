package projects.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projects.realestatemanager.service.UserService;
import projects.web.command.CreateClientCommand;
import projects.web.command.CreateUserCommand;

import javax.validation.Valid;

@Controller
@RequestMapping("/users/add")
@Slf4j
@RequiredArgsConstructor
public class AddUserController {

    private final UserService userService;

    @GetMapping
    public String getAddUserPage(Model model){
        model.addAttribute(new CreateUserCommand());
        return "user/add";
    }

    @PostMapping
    public String processAddUser(@Valid CreateUserCommand createUserCommand,
                                 BindingResult bindings){
        log.debug("Data to create user: {}", createUserCommand);
        if(bindings.hasErrors()){
            log.debug("Data contains errors: {}", bindings.getAllErrors());
            return "user/add";
        }
        try{
            userService.add(createUserCommand);
            log.debug("User created");
            return "redirect:/users";
        }catch (RuntimeException re){
            log.warn(re.getLocalizedMessage());
            log.debug("Error creating user", re);
            bindings.rejectValue(null,null, "An error occured");
            return "user/add";
        }
    }
}
