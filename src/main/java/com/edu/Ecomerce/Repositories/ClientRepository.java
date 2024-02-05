package com.edu.Ecomerce.Repositories;

import com.edu.Ecomerce.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
