package fanetech.tech.fbackend.service;

import fanetech.tech.fbackend.entites.Client;
import fanetech.tech.fbackend.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void create(Client client){
        Client clientInDB = this.clientRepository.findByEmail(client.getEmail());
        if(clientInDB == null){
        this.clientRepository.save(client);
        }
    }

    public List<Client> getAll(){
        return this.clientRepository.findAll();
    }

    public Client getOne(int id){
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        return optionalClient.orElseThrow(()-> new EntityNotFoundException("User unkwon"));
    }

    public String delete(int id){
        this.clientRepository.deleteById(id);
        return "ok";
    }

    public Client lireOuCreate(Client clientACreate){
        Client clientInDB = this.clientRepository.findByEmail(clientACreate.getEmail());
        if(clientInDB==null){
            clientInDB = this.clientRepository.save(clientACreate);
        }
        return clientInDB;
    }

    public void modifier(int id, Client client) {
        Client clientInDb = this.getOne(id);
        if(clientInDb.getId() == client.getId()){
        clientInDb.setEmail(client.getEmail());
        clientInDb.setTelephone(client.getTelephone());
        System.out.println(client.getTelephone());
        this.clientRepository.save(clientInDb);
        }
    }
}
