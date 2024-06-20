package com.example.Stock2.Controller;

import com.example.Stock2.Model.Client;
import com.example.Stock2.Repository.ClientRepository;
import com.example.Stock2.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Client")
@CrossOrigin(origins = "*")
public class ClientContoller {

    @Autowired
    ClientService clientService;
    ClientRepository clientRepository;

    @GetMapping()
    public List<Client> findAll(){
        return clientService.findAll();
    }

    @PostMapping()
    public ResponseEntity<Client> add(@RequestBody Client client){
        try {
            clientService.add(client);
            return ResponseEntity.status(HttpStatus.CREATED).body(client);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(client);
        }
    }

    @PutMapping()
    public ResponseEntity<Client> update(@RequestBody Client client){
        try {
            clientService.Update(client);
            return ResponseEntity.ok(client);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(client);
        }
    }

    @PostMapping("/delete")
    public boolean Delete(@RequestBody Client client) throws Exception {
        System.out.println(client);
        try {
            clientService.Delete(client);
            return true;
        }catch (Exception e){
            return false;
        }
    }



    @GetMapping ("/{Id}")
    public Client find(@PathVariable Long Id) throws Exception {
        return clientService.findPorId(Id);
    }




}
