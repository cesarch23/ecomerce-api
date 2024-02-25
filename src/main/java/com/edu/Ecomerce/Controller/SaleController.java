package com.edu.Ecomerce.Controller;

import com.edu.Ecomerce.DTO.ClientsProductsToBuy;
import com.edu.Ecomerce.DTO.PurchaseResponseDTO;
import com.edu.Ecomerce.Entities.Product;
import com.edu.Ecomerce.Entities.Sale;
import com.edu.Ecomerce.Services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    SaleService saleService;

    @GetMapping("/all")
    public ResponseEntity<List<Sale>> getAll(){
        return ResponseEntity.ok(saleService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity<PurchaseResponseDTO> productsToBuy(@RequestBody  ClientsProductsToBuy clientsProductsToBuy){
        PurchaseResponseDTO dto;
        try{
            dto = saleService.productListToBuy(clientsProductsToBuy);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"error en la carga");
        }
        return ResponseEntity.ok(dto);
    }



}
