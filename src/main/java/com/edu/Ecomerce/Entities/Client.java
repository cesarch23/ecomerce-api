package com.edu.Ecomerce.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "client_id")
    private int id;
    @Column(name = "client_name" , length = 100)
    private String name;
    @Column(name = "client_lastname" , length = 250)
    private String lastname;
    @Column(name = "client_dni" , length = 8)
    private String dni;




}
