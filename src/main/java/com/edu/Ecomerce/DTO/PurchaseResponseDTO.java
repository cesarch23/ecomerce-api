package com.edu.Ecomerce.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PurchaseResponseDTO
{
    private LocalDate purchaseDate;
    private double saleTotal;
    private int numberProductSold;
}
