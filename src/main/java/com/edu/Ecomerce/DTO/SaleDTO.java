package com.edu.Ecomerce.DTO;

import com.edu.Ecomerce.Entities.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {
    private int id;
    private LocalDate purchaseDate ;
    private Double total ;
    private Client client;
}
