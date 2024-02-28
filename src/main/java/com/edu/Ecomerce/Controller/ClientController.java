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


    /**
     * Obtiene la lista de todos los clientes.
     *
     * @return Lista de objetos ClientDTO que representan a todos los clientes.
     */
    @GetMapping("/all")
    public List<ClientDTO> getAll()
    {
        return clientService.getAll();
    }

    /**
     * Crea un nuevo cliente.
     *
     * @param clientDTO Objeto ClientDTO que contiene los datos del nuevo cliente.
     * @return ResponseEntity con el objeto ClientDTO creado y un código de estado 200 OK.
     *         En caso de error, puede lanzar ResponseStatusException con un código de estado diferente.
     */
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
    /**
     * Actualiza los datos de un cliente existente.
     *
     * @param clientDTO Objeto ClientDTO que contiene los datos actualizados del cliente.
     * @return ResponseEntity con el objeto ClientDTO actualizado y un código de estado 200 OK.
     *         En caso de error, puede lanzar ResponseStatusException con un código de estado diferente.
     */
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
