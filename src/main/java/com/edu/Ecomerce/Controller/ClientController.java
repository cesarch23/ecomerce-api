package com.edu.Ecomerce.Controller;

import com.edu.Ecomerce.Entities.Client;
import com.edu.Ecomerce.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAll()
    {
        return clientService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Client> getById(@PathVariable int id){
        Client c = clientService.getById(id);
        return  ResponseEntity.ok(c);
    }
    @PostMapping("/add")
    public ResponseEntity<Client> create(@RequestBody Client client){
        Client c = clientService.create(client);
        return  ResponseEntity.ok(c);
    }
    @PutMapping("/update")
    public ResponseEntity<Client> update(@RequestBody Client client) {
        Client c = clientService.update(client);
        return ResponseEntity.ok(c);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id){
        boolean b = clientService.delete(id);
        return ResponseEntity.ok(b);
    }

}
