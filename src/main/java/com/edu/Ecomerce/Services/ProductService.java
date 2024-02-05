package com.edu.Ecomerce.Services;
import com.edu.Ecomerce.Entities.Product;
import com.edu.Ecomerce.Repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    final
    ProductRepository productRepository ;

    public ProductService(ProductRepository productRepo) {
        this.productRepository = productRepo;
    }

    public List<Product> getAll(){
        return  productRepository.findAll();
    }
    public Product getById(int id){
        return productRepository.findById(id).
                orElseThrow(()->new EntityNotFoundException("producto no encontrado"));
    }
    public Product create(Product product){
        return productRepository.save(product);
    }
    public Product update(Product product){
        if(productRepository.existsById(product.getId())){
            return productRepository.save(product);
        }
        else{
            throw new EntityNotFoundException("producto no encontrado");
        }
    }
    public boolean delete(int id) {
        try {
            Product p = getById(id);
            productRepository.delete(p);
            return true;
        } catch (EntityNotFoundException ex) {
            return false;
        }
    }
}
