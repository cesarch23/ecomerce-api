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
public class ClientDTO {

    private int id;
    private String name;
    private String lastname;
    private String dni;


}
