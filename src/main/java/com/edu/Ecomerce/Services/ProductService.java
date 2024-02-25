package com.edu.Ecomerce.Services;
import com.edu.Ecomerce.DTO.ProductDTO;
import com.edu.Ecomerce.Entities.Product;
import com.edu.Ecomerce.Repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    final
    ProductRepository productRepository ;

    public ProductService(ProductRepository productRepo) {
        this.productRepository = productRepo;
    }

    public List<Product> getAll(){
        List<Product> productList = productRepository.findAll();
        return productList;
    }
    public ProductDTO getById(int id){
        Product product = productRepository.findById(id).
                orElseThrow(()->new EntityNotFoundException("producto no encontrado"));
        return convertToDTO(product);
    }
    public Product create(Product productDto){
        Product product = productRepository.save(productDto);
        return  product;
    }

    public ProductDTO update(ProductDTO dto){
        Product p = new Product();
        p.setStock(dto.getStock());
        p.setPrice(dto.getPrice());
        p.setDescription(dto.getDescription());
        p.setCode(dto.getCode());
        p.setId(dto.getId());

        if(productRepository.existsById(p.getId())){
            p = productRepository.save(p);
            return convertToDTO(p);
        }
        throw new EntityNotFoundException("producto no encontrado");
    }

    public ProductDTO convertToDTO(Product product){
        return new ProductDTO(
                product.getId(),
                product.getDescription(),
                product.getCode(),
                product.getStock(),
                product.getPrice());
    }

}
