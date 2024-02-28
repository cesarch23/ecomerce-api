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

    /**
     * Obtiene la lista de todas las ventas.
     *
     * @return ResponseEntity con la lista de objetos Sale y un código de estado 200 OK.
     */
    @GetMapping("/all")
    public ResponseEntity<List<Sale>> getAll(){
        return ResponseEntity.ok(saleService.getAll());
    }

    /**
     * Agrega una nueva venta con los productos proporcionados.
     *
     * @param clientsProductsToBuy Objeto ClientsProductsToBuy que contiene la información de la venta.
     * @return ResponseEntity con el objeto PurchaseResponseDTO correspondiente a la nueva venta y un código de estado 200 OK.
     *         En caso de error, puede lanzar ResponseStatusException con un código de estado diferente.
     */
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
