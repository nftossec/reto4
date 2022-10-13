package com.reto3_final.reto3_final.service;

import com.reto3_final.reto3_final.entity.Message;
import com.reto3_final.reto3_final.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int idMessage){
        return messageRepository.getMessage(idMessage);
    }

    public Message save(Message message){
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
        } else {
            Optional<Message> e=messageRepository.getMessage(message.getIdMessage());
            if(e.isEmpty()){
                return messageRepository.save(message);
            }else{
                return message;
            }
        }
    }

    public Message  update(Message  message){
        if(message.getIdMessage()!=null){
            Optional<Message > q = messageRepository.getMessage(message.getIdMessage());
            if(!q.isEmpty()){
                if(message.getMessageText()!=null){
                    q.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(q.get());
                return q.get();
            }else {
                return message;
            }
        }else {
            return message;
        }
    }

    /*public boolean delete(int idMessage){
        Boolean flag=false;
        Optional<Message > message= messageRepository.getMessage(idMessage);
        if(message.isPresent()){
            messageRepository.delete(message.get());
            flag=true;
        }

        return flag;
    }*/

    public boolean deleteMessage(int id){
        Boolean d = getMessage(id).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return d;
    }
}

