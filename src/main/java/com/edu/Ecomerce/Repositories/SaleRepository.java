package com.edu.Ecomerce.Repositories;

import com.edu.Ecomerce.Entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Integer> {
}
