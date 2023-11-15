package fanetech.tech.fbackend.controller;

import fanetech.tech.fbackend.entites.Client;
import fanetech.tech.fbackend.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @GetMapping(produces = "application/json")
    public List<Client> getAll(){
        return this.clientService.getAll();
    }

    @GetMapping(path = "{id}", produces = "application/json")
    public Client getOne(@PathVariable int id){
        return this.clientService.getOne(id);
    }

    public String delete(@RequestParam int id){
        return this.clientService.delete(id);
    }

    @PutMapping(path = "{id}", consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modifier(@PathVariable int id, @RequestBody Client client){
        this.clientService.modifier(id, client);
    }
}
