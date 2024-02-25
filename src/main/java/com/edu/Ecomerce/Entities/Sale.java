package com.edu.Ecomerce.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private int id;
    @Column(name = "sale_purchase_date")
    private LocalDate purchaseDate ;
    @Column(name = "sale_total")
    private Double total ;
    @ManyToOne()
    @JoinColumn(name = "client_id", referencedColumnName = "client_id", foreignKey = @ForeignKey(name = "fk_sales_clients"))
    private Client client;
    // @OneToMany(mappedBy = "sale")
    // List<SaleDetails> listDetails;



}
