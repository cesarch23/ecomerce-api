package com.edu.Ecomerce.Controller;

import com.edu.Ecomerce.DTO.ClientDTO;
import com.edu.Ecomerce.Entities.Client;
import com.edu.Ecomerce.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService ;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public List<ClientDTO> getAll()
    {
        return clientService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<ClientDTO> create(@RequestBody ClientDTO clientDTO){
        ClientDTO dto;
        try{
            dto = clientService.create(clientDTO);
        }
        catch (Exception e) {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"no se agrego el cliente");
        }
        return  ResponseEntity.ok(dto);
    }
    @PutMapping("/update")
    public ResponseEntity<ClientDTO> update(@RequestBody ClientDTO clientDTO) {
        ClientDTO dto;
        try{
            dto = clientService.update(clientDTO);
        }
        catch (Exception e) {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"no se actulizo los datos del cliente");
        }
        return  ResponseEntity.ok(dto);
    }





}
