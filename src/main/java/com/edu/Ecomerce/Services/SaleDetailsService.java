package com.edu.Ecomerce.Services;


import com.edu.Ecomerce.Entities.SaleDetails;
import com.edu.Ecomerce.Repositories.SaleDetailsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleDetailsService
{
    final
    SaleDetailsRepository saleDetailsRepository ;

    public SaleDetailsService(SaleDetailsRepository sdr) {
        this.saleDetailsRepository = sdr;
    }

    public List<SaleDetails> getAll(){
        return  saleDetailsRepository.findAll();
    }
    public SaleDetails getById(int id){
        return saleDetailsRepository.findById(id).
                orElseThrow(()->new EntityNotFoundException("saledetails not found"));
    }
    public SaleDetails create(SaleDetails sd){
        return saleDetailsRepository.save(sd);
    }
    public SaleDetails update(SaleDetails sd){
        if(saleDetailsRepository.existsById(sd.getId())){
            return saleDetailsRepository.save(sd);
        }
        else{
            throw new EntityNotFoundException("saledetails not found");
        }
    }
    public boolean delete(int id) {
        try {
            SaleDetails sd = getById(id);
            saleDetailsRepository.delete(sd);
            return true;
        } catch (EntityNotFoundException ex) {
            return false;
        }
    }
}
