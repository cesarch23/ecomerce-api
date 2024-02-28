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

    /**
     * Obtiene la lista de todos los productos.
     *
     * @return Lista de objetos Product que representan a todos los productos.
     */
    @GetMapping("/all")
    public List<Product> getAll() {
        return productService.getAll();
    }

    /**
     * Obtiene un producto por su ID.
     *
     * @param id ID del producto que se desea obtener.
     * @return ResponseEntity con el objeto ProductDTO correspondiente al producto encontrado y un código de estado 200 OK.
     *         En caso de no encontrar el producto, puede lanzar ResponseStatusException con un código de estado diferente.
     */
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

    /**
     * Crea un nuevo producto.
     *
     * @param product Objeto Product que contiene los datos del nuevo producto.
     * @return ResponseEntity con el objeto Product creado y un código de estado 200 OK.
     *         En caso de error, puede lanzar ResponseStatusException con un código de estado diferente.
     */
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

    /**
     * Actualiza los datos de un producto existente.
     *
     * @param product Objeto ProductDTO que contiene los datos actualizados del producto.
     * @return ResponseEntity con el objeto ProductDTO actualizado y un código de estado 200 OK.
     *         En caso de error, puede lanzar ResponseStatusException con un código de estado diferente.
     */
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

