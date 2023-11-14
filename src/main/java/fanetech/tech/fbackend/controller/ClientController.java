package fanetech.tech.fbackend.controller;

import fanetech.tech.fbackend.entites.Client;
import fanetech.tech.fbackend.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "client")
public class ClientController {
       private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public void create(@RequestBody Client client){
        this.clientService.create(client);

    }
}
