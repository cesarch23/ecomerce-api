package com.edu.Ecomerce.Services;

import com.edu.Ecomerce.Entities.Client;
import com.edu.Ecomerce.Repositories.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    final
    ClientRepository clientRepository ;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAll(){
        return  clientRepository.findAll();
    }
    public Client getById(int id){
        return clientRepository.findById(id).
                orElseThrow(()->new EntityNotFoundException("cliente no encontrado"));
    }
    public Client create(Client client){
         return clientRepository.save(client);
    }
    public Client update(Client client){
        if(clientRepository.existsById(client.getId())){
        return clientRepository.save(client);
        }
        else{
        throw new EntityNotFoundException("cliente no encontrado");
        }
    }
    public boolean delete(int id) {
        try {
            Client c = getById(id);
            clientRepository.delete(c);
            return true;
        } catch (EntityNotFoundException ex) {
            return false;
        }
    }

}
