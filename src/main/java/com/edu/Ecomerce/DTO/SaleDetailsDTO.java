package com.edu.Ecomerce.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleDetailsDTO {

    private int id;
    private int amount;
    private double Subtotal;
    private ProductDTO productDTO;
    private SaleDTO saleDTO;


}
