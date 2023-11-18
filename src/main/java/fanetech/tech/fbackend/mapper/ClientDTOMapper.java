package fanetech.tech.fbackend.mapper;

import fanetech.tech.fbackend.dto.ClientDTO;
import fanetech.tech.fbackend.entites.Client;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ClientDTOMapper implements Function<Client, ClientDTO> {

    @Override
    public ClientDTO apply(Client client) {
        return new ClientDTO(client.getId(), client.getEmail(), client.getTelephone());
    }
}
