package com.reto3_final.reto3_final.service;

import com.reto3_final.reto3_final.entity.Client;
import com.reto3_final.reto3_final.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int idClient){
        return clientRepository.getClient(idClient);
    }

    public Client save(Client client){
        if(client.getIdClient()==null){
            return clientRepository.save(client);
        } else {
            Optional<Client > e=clientRepository.getClient(client.getIdClient());
            if(e.isEmpty()){
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }

    public Client  update(Client  client) {
        if (client.getIdClient() != null) {
            Optional<Client> q = clientRepository.getClient(client.getIdClient());
            if (!q.isEmpty()) {
                if (client.getName() != null) {
                    q.get().setName(client.getName());
                }
                if (client.getEmail() != null) {
                    q.get().setEmail(client.getEmail());
                }
                if (client.getPassword() != null) {
                    q.get().setPassword(client.getPassword());
                }

                if (client.getAge() != null) {
                    q.get().setAge(client.getAge());
                }

                clientRepository.save(q.get());
                return (q.get());
            }else {
                return client;
            }
        }else {
            return client;
        }
    }

    /*
    ******************+ reto 2 update con is present ************************
    public Client  update(Client  client){
        if(client.getIdReservation()!=null){
            Optional<Client > q = clientRepository.getClient(client.getIdReservation());
            if(q.isPresent()){
                if(client.getName()!=null){
                    q.get().setName(client.getName());
                }
                if(client.getEmail()!=null){
                    q.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null){
                    q.get().setPassword(client.getPassword());
                }

                if(client.getAge()!=null){
                    q.get().setAge(client.getAge());
                }

                clientRepository.save(q.get());
                return q.get();

            }else {
                return client;
            }

        }else {
            return client;
        }
    }*/


    /*  **********+delete reto 2  con bandera *****************************
        public boolean delete(int id){
        Boolean flag=false;
        Optional<Client > client=clientRepository.getClient(id);
        if(client.isPresent()){
            clientRepository.delete(client.get());
            flag=true;
        }

        return flag;
    }
    ***********************************************************
    */

    public boolean deleteClient(int id){
        Boolean d = getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return d;
    }
}

