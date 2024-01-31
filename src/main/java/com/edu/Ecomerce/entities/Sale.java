package com.edu.Ecomerce.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private int id;
    @Column(name = "sale_purchase_date")
    private Date purchaseDate ;
    @Column(name = "sale_total")
    private Double total ;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_sales_clients")
    private Client client;

    public Sale() {
    }

    public Sale(int id, Date purchaseDate, Double total, Client client) {
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.total = total;
        this.client = client;
    }
}
