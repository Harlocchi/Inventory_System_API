package com.example.Stock2.Controller;

import com.example.Stock2.Model.Client;
import com.example.Stock2.Model.Product;
import com.example.Stock2.Model.Sale;
import com.example.Stock2.Repository.ClientRepository;
import com.example.Stock2.Repository.SaleRepository;
import com.example.Stock2.Services.ClientService;
import com.example.Stock2.Services.ProductService;
import com.example.Stock2.Services.SaleService;
import com.example.Stock2.VOs.ProductSale;
import com.example.Stock2.VOs.SalePostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/Sale")
@CrossOrigin(origins = "*")
public class SaleController {

    @Autowired
    ClientService clientService;

    @Autowired
    SaleService saleService;

    @Autowired
    SaleRepository saleRepository;
    @Autowired
    ProductService productService;

    @Autowired
    ClientRepository clientRepository;

    @PostMapping()
    public Boolean create(@RequestBody Sale sale) throws Exception {
        try {
            saleRepository.save(sale);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @GetMapping()
    public List<Sale> GetAll() {
        return saleService.findAll();
    }

    @DeleteMapping("/delete")
    public boolean delete(Sale sale) {
        return saleService.deleteByEntity(sale);
    }

    public boolean update(Sale sale) {
        return saleService.update(sale);
    }

}
