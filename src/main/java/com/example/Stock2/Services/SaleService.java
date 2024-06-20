package com.example.Stock2.Services;
import com.example.Stock2.Model.Product;
import com.example.Stock2.Model.Sale;
import com.example.Stock2.Repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SaleService {

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    ProductService productService;

    public List<Sale> findAll(){
        return saleRepository.findAll();
    }

    public boolean add(Sale sale){
        try {
            saleRepository.save(sale);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public String HashMapForString(HashMap<String, String> map){

        StringBuilder stringBuilder = new StringBuilder();
        Set<String> keys = map.keySet();
        Collection<String> values = map.values();

        List<String> key2 = new ArrayList<>(keys);
        List<String> values2 = new ArrayList<>(values);

        for(int i = 0; i < key2.size(); i++){
            stringBuilder.append(key2.get(i));
            stringBuilder.append("-");
            stringBuilder.append(values2.get(i));
            stringBuilder.append("|");
        }
        stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());

        return String.valueOf(stringBuilder);

    }

    public boolean deleteByEntity(Sale sale){
        try {
            saleRepository.delete(sale);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public boolean update (Sale sale){
        try {
            saleRepository.saveAndFlush(sale);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public Sale findporId(Long Id) throws Exception {

        return saleRepository.findById(Id).
                orElseThrow(() -> new  Exception(""));

    }







}
