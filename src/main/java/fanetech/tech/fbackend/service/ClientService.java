package fanetech.tech.fbackend.service;

import fanetech.tech.fbackend.entites.Client;
import fanetech.tech.fbackend.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void create(Client client){
        this.clientRepository.save(client);
    }
}
