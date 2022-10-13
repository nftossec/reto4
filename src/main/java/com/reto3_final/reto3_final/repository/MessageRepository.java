package com.reto3_final.reto3_final.repository;

import com.reto3_final.reto3_final.entity.Message;
import com.reto3_final.reto3_final.repository.crudRepository.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }

    public Message save(Message message){
        return messageCrudRepository.save(message);
    }

    public Optional<Message> getMessage(Integer idMessage){
        return messageCrudRepository.findById(idMessage);
    }

    public void delete(Message message){
        messageCrudRepository.delete(message);
    }
}

