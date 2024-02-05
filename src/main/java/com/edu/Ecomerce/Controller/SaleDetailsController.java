package com.edu.Ecomerce.Controller;

import com.edu.Ecomerce.Entities.SaleDetails;
import com.edu.Ecomerce.Services.SaleDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sales-details")
public class SaleDetailsController {
    @Autowired
    SaleDetailsService saleDetailsService;
    @GetMapping("/all")
    public ResponseEntity<List<SaleDetails>> getAll(){
        return ResponseEntity.ok(saleDetailsService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity<SaleDetails> add(@RequestBody SaleDetails saleDetails){
        return  ResponseEntity.ok(saleDetailsService.create(saleDetails));
    }
}
