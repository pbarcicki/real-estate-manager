package projects.realestatemanager.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projects.realestatemanager.domain.model.User;
import projects.realestatemanager.domain.repository.UserRepository;
import projects.realestatemanager.service.UserService;
import projects.realestatemanager.web.command.EditUserCommand;

import javax.validation.Valid;

@Controller
@RequestMapping("/users/edit")
@Slf4j
@RequiredArgsConstructor
public class EditUserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("/{id:[0-9]+}")
    public String showUserEdit(Model model, @PathVariable Long id){
        User user = userRepository.getOne(id);
        model.addAttribute(new EditUserCommand());
        model.addAttribute("userEdit", userService.showUser(id));
        return "user/edit";
    }
    @PostMapping("/{id:[0-9]+}")
    public String editUser(@Valid EditUserCommand editUserCommand,
                           BindingResult bindingResult){
        Long id = editUserCommand.getId();
        log.warn("Value user active: {}", editUserCommand.getIsActive());
        try{
            boolean success = userService.edit(editUserCommand);
            log.debug("Successful data change");
            return "redirect:/users/list";
        }catch (RuntimeException re){
            log.warn(re.getLocalizedMessage());
            log.error("Error while editing data", re);
            bindingResult.rejectValue("errors", null,
                    "An unknown error occured while editing user");
        }
        return ("redirect:/users/edit/" +id);
    }
    @PostMapping
    public String deleteUser(@Valid EditUserCommand editUserCommand,
                             BindingResult bindingResult) {
        Long id = editUserCommand.getId();
        log.warn("Value user active: {}", editUserCommand.getIsActive());
        try {
            //userService.delete(editUserCommand);
            log.debug("Successful user delete");
            return "redirect:/users/list";
        } catch (RuntimeException re) {
            log.warn(re.getLocalizedMessage());
            log.error("Error while editing data", re);
            bindingResult.rejectValue("errors", null,
                    "An unknown error occured while editing user");
        }
        return ("redirect:/users/edit/delete/" + id);
    }

}
