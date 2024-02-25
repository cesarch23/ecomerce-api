package com.edu.Ecomerce.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
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
    private double subtotal;

    @Column(name = "sale_details_sale_price")
    private double salePrice;

    @ManyToOne()
    @JoinColumn(name = "product_id", referencedColumnName ="product_id", foreignKey = @ForeignKey(name = "fk_sale_details_products"))
    private Product product;
    @ManyToOne()
    @JoinColumn(name = "sale_id", referencedColumnName ="sale_id", foreignKey = @ForeignKey(name = "fK_sale_details_sale"))
    private  Sale sale;


}
