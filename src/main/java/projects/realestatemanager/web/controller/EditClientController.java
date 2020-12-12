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
import projects.realestatemanager.domain.model.Client;
import projects.realestatemanager.domain.repository.ClientRepository;
import projects.realestatemanager.service.ClientService;
import projects.realestatemanager.web.command.EditClientCommand;

import javax.validation.Valid;

@Controller
@RequestMapping("/clients/edit")
@Slf4j
@RequiredArgsConstructor
public class EditClientController {

    private final ClientService clientService;
    private final ClientRepository clientRepository;

    @GetMapping("/{id:[0-9]+}")
    public String showClientEdit(Model model, @PathVariable Long id){
        Client client = clientRepository.getOne(id);
        model.addAttribute(new EditClientCommand());
        model.addAttribute("clientEdit", clientService.showClient(id));
        return "client/edit";
    }

    @PostMapping("/{id:[0-9]+}")
    public String editClient(@Valid EditClientCommand editClientCommand,
                             BindingResult bindingResult){
        Long id = editClientCommand.getId();
        try{
            boolean success = clientService.edit(editClientCommand);
            log.debug("Successful data change");
            return "redirect:/clients/list";
        }catch (RuntimeException re){
            log.warn(re.getLocalizedMessage());
            log.error("Error while editing data", re);
            bindingResult.rejectValue("errors", null,
                    "An unknown error occured while editing client");
        }
        return ("redirect:/clients/edit/" + id);
    }


}
