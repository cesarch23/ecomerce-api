package com.edu.Ecomerce.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;
    @Column(name = "product_description")
    private String description;
    @Column(name = "product_code")
    private String code;
    @Column(name = "product_stock")
    private int stock;
    @Column(name = "product_price")
    private double price;
    //@OneToMany(mappedBy = "product")
    //List<SaleDetails> listDetail;


}
