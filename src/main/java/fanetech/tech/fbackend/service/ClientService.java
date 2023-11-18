package fanetech.tech.fbackend.service;

import fanetech.tech.fbackend.dto.ClientDTO;
import fanetech.tech.fbackend.entites.Client;
import fanetech.tech.fbackend.mapper.ClientDTOMapper;
import fanetech.tech.fbackend.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ClientService {
    private ClientRepository clientRepository;
    private ClientDTOMapper clientDTOMapper;

    public ClientService(ClientRepository clientRepository, ClientDTOMapper clientDTOMapper) {
        this.clientRepository = clientRepository;
        this.clientDTOMapper = clientDTOMapper;
    }

    public void create(Client client){
        Client clientInDB = this.clientRepository.findByEmail(client.getEmail());
        if(clientInDB == null){
        this.clientRepository.save(client);
        }
    }

    public Stream<ClientDTO> getAll(){
        return this.clientRepository.findAll()
                .stream().map(clientDTOMapper);
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
