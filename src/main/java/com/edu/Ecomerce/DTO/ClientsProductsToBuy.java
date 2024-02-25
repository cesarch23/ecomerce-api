package com.edu.Ecomerce.DTO;

import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientsProductsToBuy {

    private ClientSaleDTO cliente;
    private List<LineaDTO> lineas;


    @Getter
    public static class ClientSaleDTO {
        private int clienteid;

    }

    @Getter
    public  static class LineaDTO {
        private Integer cantidad;
        private ProductSaleDTO producto;

    }

    @Getter
    public static class ProductSaleDTO {
        private int productoid;

    }

}
