package com.edu.Ecomerce.Controller;

import com.edu.Ecomerce.DTO.SaleDetailsDTO;
import com.edu.Ecomerce.Entities.SaleDetails;
import com.edu.Ecomerce.Services.SaleDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("sales-details")
public class SaleDetailsController {
    @Autowired
    SaleDetailsService saleDetailsService;

    /**
     * Obtiene la lista de todos los detalles de ventas.
     *
     * @return ResponseEntity con la lista de objetos SaleDetails y un código de estado 200 OK.
     */
    @GetMapping("/all")
    public ResponseEntity<List<SaleDetails>> getAll(){
        return ResponseEntity.ok(saleDetailsService.getAll());
    }

}
