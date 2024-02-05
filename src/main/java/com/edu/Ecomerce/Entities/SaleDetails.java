package com.edu.Ecomerce.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "sale_details")
public class SaleDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_detail_id")
    private int id;
    @Column(name = "sale_detail_amount")
    private int amount;
    @Column(name = "sale_detail_price")
    private double price;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sale_id", referencedColumnName ="sale_id", foreignKey = @ForeignKey(name = "fK_sale_details_sale"))
    private  Sale sale;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName ="product_id", foreignKey = @ForeignKey(name = "fk_sale_details_products"))
    private Product product;

    public  SaleDetails(){}

    public SaleDetails(int id, int amount, double price, Sale sale, Product product) {
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.sale = sale;
        this.product = product;
    }
}
