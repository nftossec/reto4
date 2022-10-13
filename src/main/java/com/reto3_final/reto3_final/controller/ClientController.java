package com.reto3_final.reto3_final.controller;

import com.reto3_final.reto3_final.entity.Category;
import com.reto3_final.reto3_final.entity.Client;
import com.reto3_final.reto3_final.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getClients(){
        return clientService.getAll();
    }

    @GetMapping("{id}")
    public Optional <Client> getClient(@PathVariable("id")int id){
        return clientService.getClient(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client postClient(@RequestBody Client client){
        return clientService.save(client);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client){
        return clientService.update(client);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteClient (@PathVariable("id")int id){
        return clientService.deleteClient(id);
    }

}
