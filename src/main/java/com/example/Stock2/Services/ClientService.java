package com.example.Stock2.Services;

import com.example.Stock2.Model.Client;
import com.example.Stock2.Repository.ClientRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> findAll(){
       return clientRepository.findAll();
    }

    public boolean add(Client client){
        try {
            clientRepository.save(client);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean Delete(Client client){
        try {
            clientRepository.deleteById(client.getId());
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean Update(Client clientExisting){
        try {
            clientRepository.saveAndFlush(clientExisting);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Client findPorId(Long Id) throws Exception {
        return clientRepository.findById(Id)
                .orElseThrow(() -> new  Exception(""));
    }

    public Client ForClient(Long Id) throws Exception {
        return clientRepository.findById(Id).orElseThrow(() -> new Exception(""));

    }

    public Client StringforClient(String Id) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(Id);
        Long Ids = jsonNode.get("Id").asLong();


        return findPorId(Ids);
    }





}
