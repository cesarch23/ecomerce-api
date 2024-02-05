package com.edu.Ecomerce.Services;


import com.edu.Ecomerce.Entities.Sale;
import com.edu.Ecomerce.Repositories.SaleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
    final
    SaleRepository saleRepository ;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<Sale> getAll(){
        return  saleRepository.findAll();
    }
    public Sale getById(int id){
        return saleRepository.findById(id).
                orElseThrow(()->new EntityNotFoundException("sale not found"));
    }
    public Sale create(Sale sale){
        return saleRepository.save(sale);
    }
    public Sale update(Sale sale){
        if(saleRepository.existsById(sale.getId())){
            return saleRepository.save(sale);
        }
        else{
            throw new EntityNotFoundException("sale not found");
        }
    }
    public boolean delete(int id) {
        try {
            Sale s = getById(id);
            saleRepository.delete(s);
            return true;
        } catch (EntityNotFoundException ex) {
            return false;
        }
    }
}
