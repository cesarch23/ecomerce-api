package com.edu.Ecomerce.Controller;
import com.edu.Ecomerce.Entities.Product;
import com.edu.Ecomerce.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll()
    {
        return productService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id){
        Product p = productService.getById(id);
        return  ResponseEntity.ok(p);
    }
    @PostMapping("/add")
    public ResponseEntity<Product> create(@RequestBody Product product){
        Product p = productService.create(product);
        return  ResponseEntity.ok(p);
    }
    @PutMapping("/update")
    public ResponseEntity<Product> update(@RequestBody Product product) {
        Product p = productService.update(product);
        return ResponseEntity.ok(p);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id){
        boolean b = productService.delete(id);
        return ResponseEntity.ok(b);
    }
}
