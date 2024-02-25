package com.edu.Ecomerce.Services;

import com.edu.Ecomerce.DTO.ClientDTO;
import com.edu.Ecomerce.Entities.Client;
import com.edu.Ecomerce.Repositories.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    final
    ClientRepository clientRepository ;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientDTO> getAll(){
        List<Client> clients = clientRepository.findAll();
        List<ClientDTO> dtos = new ArrayList<>( );
        for ( Client c:clients  )  {
            dtos.add(convertToDTO(c));
        }
        return dtos;
    }
    public ClientDTO getById(int id){
        Client c = clientRepository.findById(id).
                orElseThrow(()->new EntityNotFoundException("cliente no encontrado"));
        return convertToDTO(c);
    }
    public ClientDTO create(ClientDTO clientDto){
        Client c = clientRepository.save(convertToClient(clientDto));
        return  convertToDTO(c);
    }
    public ClientDTO update(ClientDTO clientDTO){
        Client client = convertToClient(clientDTO);

        if(clientRepository.existsById(client.getId())) {
            client = clientRepository.save(client);
            return convertToDTO(client);
        }
        throw new EntityNotFoundException("cliente no encontrado");

    }

    public  Client convertToClient(ClientDTO clientDTO){
        return new Client(clientDTO.getId(),clientDTO.getName(),clientDTO.getLastname(),clientDTO.getDni());
    }

    public  ClientDTO convertToDTO(Client cli){
        return  new ClientDTO(cli.getId(),cli.getName(),cli.getLastname(),cli.getDni());
    }

}
