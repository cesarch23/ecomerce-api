package com.edu.Ecomerce.Entities;

import jakarta.persistence.*;
import lombok.Data;

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

    public  Product(){}
    public Product(int id, String description, String code, int stock, double price) {
        this.id = id;
        this.description = description;
        this.code = code;
        this.stock = stock;
        this.price = price;
    }
}
