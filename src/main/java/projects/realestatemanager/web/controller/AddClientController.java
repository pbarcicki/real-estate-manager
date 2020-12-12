package projects.realestatemanager.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import projects.realestatemanager.exception.ClientAlreadyExistException;
import projects.realestatemanager.service.ClientService;
import projects.realestatemanager.web.command.CreateClientCommand;

import javax.validation.Valid;

@Controller
@RequestMapping("/clients/add")
@Slf4j
@RequiredArgsConstructor
public class AddClientController {

    private final ClientService clientService;

    @GetMapping
    public String getAddClientPage(Model model){
        model.addAttribute(new CreateClientCommand());
        return "client/add";
    }

    @PostMapping
    public String processAddClient(@Valid CreateClientCommand createClientCommand,
                                   BindingResult bindings){
        log.debug("Data to create client: {}", createClientCommand);
        if(bindings.hasErrors()){
            log.debug("Data contains errors: {}", bindings.getAllErrors());
            return "client/add";
        }
        try{
            clientService.add(createClientCommand);
            log.debug("Client created");
            return "redirect:/clients";

        }catch(ClientAlreadyExistException cae){
            log.debug("Error creating client", cae);
            bindings.rejectValue("clientContactEmail",null, "Client with this e-mail already exist");
            return "client/add";
        }catch (RuntimeException re){
            bindings.rejectValue(null,null, "Error");
            return "client/add";
        }
    }

}
