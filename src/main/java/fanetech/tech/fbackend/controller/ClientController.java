package fanetech.tech.fbackend.controller;

import fanetech.tech.fbackend.dto.ErrorEntity;
import fanetech.tech.fbackend.entites.Client;
import fanetech.tech.fbackend.service.ClientService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
/*
***********************1st to handle error**************************
    @GetMapping(path = "{id}", produces = "application/json")
    public ResponseEntity getOne(@PathVariable int id){
        try{
        Client client =  this.clientService.getOne(id);
            return ResponseEntity.ok(client);
        }catch (EntityNotFoundException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorEntity(null, exception.getMessage()));
        }
    }
*/
    /*
    * ****************************2nd to handle error**************************************
    * */
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

    /*
     * ****************************2nd to handle error**************************************
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({EntityNotFoundException.class})
    public ErrorEntity handleException(EntityNotFoundException exception){
        return new ErrorEntity(null, exception.getMessage());
    }
     * */
}
