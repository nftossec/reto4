package com.reto3_final.reto3_final.repository;

import com.reto3_final.reto3_final.entity.Category;
import com.reto3_final.reto3_final.entity.Client;
import com.reto3_final.reto3_final.repository.crudRepository.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }


    public Client save(Client client){
        return clientCrudRepository.save(client);
    }


    public Optional<Client> getClient(Integer idClient){
        return clientCrudRepository.findById(idClient);
    }

    public void delete(Client client){
        clientCrudRepository.delete(client);
    }

}

