package com.edu.Ecomerce.Services;


import com.edu.Ecomerce.DTO.PurchaseDate;
import com.edu.Ecomerce.DTO.PurchaseResponseDTO;
import com.edu.Ecomerce.DTO.SaleDTO;
import com.edu.Ecomerce.DTO.ClientsProductsToBuy;
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
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {
    @Autowired
    SaleRepository saleRepository ;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SaleDetailsRepository saleDetailsRepository;

    RestTemplate restTemplate =  new RestTemplate();
    final String url= "http://worldclockapi.com/api/json/utc/now";


    public SaleService() { }

    public PurchaseDate getExternalPurchaseDate(){
        try {
            return restTemplate.getForObject(url,PurchaseDate.class);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no encontrado");
        }
    }


    public LocalDate getDateForPurchase() {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String dateTime = getExternalPurchaseDate().getCurrentDateTime().split("T")[0];
            return LocalDate.parse(dateTime, formatter);
        } catch (Exception e) {
            return LocalDate.now();
        }
    }

    public List<Sale> getAll(){
        return  saleRepository.findAll();
    }

    public PurchaseResponseDTO productListToBuy(ClientsProductsToBuy shopping) throws Exception {
        if(!shopping.getLineas().isEmpty() && verifyProduct(shopping) && verifyStock(shopping)){

            PurchaseResponseDTO dto = new PurchaseResponseDTO();
            Client clientFounded = findClientById(shopping.getCliente().getClienteid());
            Sale saleCreated = createSale(shopping,clientFounded);

            for(ClientsProductsToBuy.LineaDTO linea: shopping.getLineas()){

                SaleDetails saleDetails = new SaleDetails();
                saleDetails.setAmount(linea.getCantidad());

                Product pFounded = findProductById(linea.getProducto().getProductoid());

                saleDetails.setProduct(pFounded);
                saleDetails.setSalePrice(pFounded.getPrice());

                SaleDetails s = create(saleDetails,saleCreated);

            }
            dto.setSaleTotal(saleCreated.getTotal());
            dto.setPurchaseDate(saleCreated.getPurchaseDate());
            dto.setNumberProductSold(countProducts(shopping));
            return dto;

        }
        throw new Exception(" no se inserto la totalidad de los productos");
    }

    public SaleDetails create(SaleDetails sd, Sale saleCreated) throws Exception {

        Product productFounded = findProductById(sd.getProduct().getId());

        if (productFounded.getStock()>=sd.getAmount()) {

            double subtotal = sd.getAmount() * productFounded.getPrice();
            SaleDetails saleDetail = new SaleDetails();
            saleDetail.setAmount(sd.getAmount());
            saleDetail.setSubtotal(subtotal);
            saleDetail.setSalePrice(sd.getSalePrice());

            productFounded.setStock(productFounded.getStock() - sd.getAmount());
            saleDetail.setProduct(productFounded);
            saleDetail.setSale(saleCreated);

            return saleDetailsRepository.save(saleDetail);

        }
        throw new Exception("stock insuficiente");
    }
    public int countProducts(ClientsProductsToBuy shopping){
        int amount=0;
        for(var linea: shopping.getLineas()){
            amount +=  linea.getCantidad();
        }
        return amount;
    }
    public  Client findClientById(int id){
        return clientRepository.findById(id).orElseThrow(()->new EntityNotFoundException("cliente no encontrado"));
    }
    public  Product findProductById(int id){
        return productRepository.findById(id).orElseThrow(()->new EntityNotFoundException("producto no hallado"));
    }
    public Sale createSale(ClientsProductsToBuy shopping,Client clientFounded){

        Sale sale = new Sale();
        sale.setPurchaseDate(getDateForPurchase());
        sale.setTotal(getSaleTotal(shopping));
        sale.setClient(clientFounded);
        return saleRepository.save(sale);
    }
    public  boolean verifyProduct(ClientsProductsToBuy shopping){
        boolean aux = false;
        for(ClientsProductsToBuy.LineaDTO linea: shopping.getLineas()) {
            if(!clientRepository.existsById(linea.getProducto().getProductoid())) break;
            aux = true;
        }
        return aux;
    }

    public boolean verifyProduct2(ClientsProductsToBuy shopping) {
        return shopping.getLineas().stream()
                .allMatch(linea -> clientRepository.existsById(linea.getProducto().getProductoid()));
    }
    public  boolean verifyStock(ClientsProductsToBuy shopping){
        boolean aux = false;
        for(ClientsProductsToBuy.LineaDTO line: shopping.getLineas()){
            Product product = productRepository.findById(line.getProducto().getProductoid())
                    .orElseThrow(()-> new EntityNotFoundException(" producto no hallado"));
            if(!(product.getStock() >= line.getCantidad())) break;
            aux = true;

        }
        return aux;
    }
    public  double getSaleTotal(ClientsProductsToBuy shopping){
        double total = 0.00;
        for(ClientsProductsToBuy.LineaDTO line: shopping.getLineas()){
            Product product = productRepository.findById(line.getProducto().getProductoid())
                    .orElseThrow(()-> new EntityNotFoundException(" producto no hallado"));
           total += product.getPrice() * line.getCantidad();
        }
        return total;
    }




}
