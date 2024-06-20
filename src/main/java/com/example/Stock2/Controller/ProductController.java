package com.example.Stock2.Controller;
import com.example.Stock2.Model.Product;
import com.example.Stock2.Repository.ClientRepository;
import com.example.Stock2.Repository.ProductRepository;
import com.example.Stock2.Services.ProductService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;




@RestController
@RequestMapping("/Product")
@CrossOrigin(origins = "*")
public class ProductController {


    @Autowired
    ProductRepository productRepository;
    @Autowired
    private ProductService productService;


    @GetMapping()
    public List<Product> findAll(){
       return productService.findAll();
    }


    @PostMapping()
    public ResponseEntity<Product> add(@RequestBody Product product){
        productService.add(product);
        return ResponseEntity.ok(product);
    }


    @PutMapping()
    public Boolean update( @RequestBody Product product) throws Exception {
        return productService.update(product);
    }


    @PostMapping("/delete ")
    public boolean delete(@RequestBody Product product){
        System.out.println(product);
        return productService.Delete(product);
    }



    @GetMapping("/{Id}")
    public Product findById(@PathVariable Long Id) throws Exception {
        return productService.findPorId(Id);
    }
}
