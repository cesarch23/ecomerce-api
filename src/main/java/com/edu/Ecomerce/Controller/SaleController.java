package com.edu.Ecomerce.Controller;

import com.edu.Ecomerce.Entities.Sale;
import com.edu.Ecomerce.Services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Sale> add(@RequestBody Sale sale)
    {
        return ResponseEntity.ok(saleService.create(sale));
    }
}
