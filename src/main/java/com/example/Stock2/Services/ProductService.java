package com.example.Stock2.Services;

import com.example.Stock2.Model.Product;
import com.example.Stock2.Repository.ProductRepository;
import com.sun.jdi.event.ExceptionEvent;
import jakarta.persistence.Id;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.FalseCondition;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }


    public List<Product> findAll(){
        return productRepository.findAll();
    }



    public Product findPorId(Long Id) throws Exception {
        return productRepository.findById(Id)
                .orElseThrow(() -> new Exception(""));
    }


    public boolean add(Product product){
        try {
            productRepository.save(product);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean update(Product product) throws Exception {
            productRepository.saveAndFlush(product);
            return true;
    }

    public boolean Delete(Product product){
        try {
            productRepository.deleteById(product.getId());
            return true;
        }catch (Exception e){
            return false;
        }
    }



}
