package com.edu.Ecomerce.Controller;
import com.edu.Ecomerce.DTO.ProductDTO;
import com.edu.Ecomerce.Entities.Product;
import com.edu.Ecomerce.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll() {
        return productService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable int id){
        ProductDTO p;
        try {
            p = productService.getById(id);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"producto no encontrado");
        }
        return  ResponseEntity.ok(p);
    }
    @PostMapping("/add")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product p;
        try {
            p = productService.create(product);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "producto no agregado");
        }
        return ResponseEntity.ok(p);
    }
    @PutMapping("/update")
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO product) {

        ProductDTO p;
        try{
           p = productService.update(product);
         }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"No se actulizo los datos");
        }
        return ResponseEntity.ok(p);
    }

}

