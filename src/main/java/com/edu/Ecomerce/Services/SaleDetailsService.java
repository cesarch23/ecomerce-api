package com.edu.Ecomerce.Services;


import com.edu.Ecomerce.DTO.ProductDTO;
import com.edu.Ecomerce.DTO.PurchaseDate;
import com.edu.Ecomerce.DTO.SaleDTO;
import com.edu.Ecomerce.DTO.SaleDetailsDTO;
import com.edu.Ecomerce.Entities.Client;
import com.edu.Ecomerce.Entities.Product;
import com.edu.Ecomerce.Entities.Sale;
import com.edu.Ecomerce.Entities.SaleDetails;
import com.edu.Ecomerce.Repositories.ClientRepository;
import com.edu.Ecomerce.Repositories.ProductRepository;
import com.edu.Ecomerce.Repositories.SaleDetailsRepository;
import com.edu.Ecomerce.Repositories.SaleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleDetailsService {
    @Autowired
    SaleDetailsRepository saleDetailsRepository;
    @Autowired
     ProductRepository productRepository;
    @Autowired
     ClientRepository clientRepository;
    @Autowired
     SaleRepository saleRepository;
    RestTemplate restTemplate =  new RestTemplate();
    final String url= "http://worldclockapi.com/api/json/utc/now";

    public SaleDetailsService(){
    }

    public List<SaleDetails> getAll() {
        return saleDetailsRepository.findAll();
    }

    public SaleDetails getById(int id) {
        return saleDetailsRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("saledetails not found"));
    }
    public SaleDetails create(SaleDetails sd) {
        SaleDetails sdCreated = new SaleDetails();

        Product productFounded = productRepository.findById(sd.getProduct().getId())
                    .orElseThrow(()->new EntityNotFoundException("no se econtro el producto"));

        Client clientFounded = clientRepository.findById(sd.getSale().getClient().getId())
                .orElseThrow(()->new EntityNotFoundException("cliente no encontrado"));

           if (productFounded.getStock()>=sd.getAmount()) {

               double total = sd.getAmount() * productFounded.getPrice();

               Sale sale = new Sale();
               sale.setPurchaseDate(getDateForPurchase());
               sale.setTotal(total);
               sale.setClient(clientFounded);
               Sale saleCreated = createSale(sale);

               SaleDetails saleDetail = new SaleDetails();
               saleDetail.setAmount(sd.getAmount());
               saleDetail.setSubtotal(total);

               productFounded.setStock(productFounded.getStock() - sd.getAmount());
               saleDetail.setProduct(productFounded);

               saleDetail.setSale(saleCreated);

               sdCreated = saleDetailsRepository.save(saleDetail);

            }
           else{
               throw new RuntimeException("");
           }
           return sdCreated;
    }


    public Sale createSale(Sale sale){
        return saleRepository.save(sale);
    }

    public PurchaseDate getExternalPurchaseDate(){
        try {
            return restTemplate.getForObject(url,PurchaseDate.class);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no encontrado");
        }
    }

    public LocalDate getDateForPurchase(){
        try {
            String[] complete = getExternalPurchaseDate().getCurrentDateTime().split("-") ;

            String day = complete[2].substring(0,2);
            return LocalDate.parse(complete[0]+"-"+complete[1]+"-"+day);
        }
        catch (Exception e){
            LocalDate date = LocalDate.now();
            return date;
        }
    }



}
