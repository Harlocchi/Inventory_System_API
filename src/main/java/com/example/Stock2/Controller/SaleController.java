package com.example.Stock2.Controller;

import com.example.Stock2.Model.Client;
import com.example.Stock2.Model.Sale;
import com.example.Stock2.Repository.ClientRepository;
import com.example.Stock2.Repository.SaleRepository;
import com.example.Stock2.Services.ClientService;
import com.example.Stock2.Services.SaleService;
import com.example.Stock2.VOs.SalePostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.*;

@RestController
@RequestMapping("/Sale")
public class SaleController {

    @Autowired
    ClientService clientService;

    @Autowired
    SaleService saleService;

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    ClientRepository clientRepository;

    @PostMapping("/createSale")
    public Boolean create(@RequestBody SalePostVO salePostVO) throws Exception {
        Client clientForSale =  clientService.findPorId(salePostVO.getValueLong());
        String stringProducts = saleService.HashMapForString(salePostVO.getHashmap());
        Sale sale = new Sale(salePostVO.getValueLong(), clientForSale,stringProducts);
        return saleService.add(sale);
    }

    @GetMapping("/findAll")
    public List<Sale> GetAll(){
        return saleService.findAll();
    }

    @DeleteMapping("/delete")
    public boolean delete(Sale sale){
        return saleService.deleteByEntity(sale);
    }

    public boolean update(Sale sale){
        return saleService.update(sale);
    }








}
