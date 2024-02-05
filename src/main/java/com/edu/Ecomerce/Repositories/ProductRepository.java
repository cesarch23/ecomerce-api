package com.edu.Ecomerce.Repositories;

import com.edu.Ecomerce.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
