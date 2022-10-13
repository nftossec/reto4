package com.reto3_final.reto3_final.controller;


import com.reto3_final.reto3_final.entity.Bike;
import com.reto3_final.reto3_final.entity.Message;
import com.reto3_final.reto3_final.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getMessages(){
        return messageService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message postMessage(@RequestBody Message message){
        return messageService.save(message);
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public Message postMessage2(@RequestBody Message message){
        return messageService.save(message);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message message){
        return messageService.update(message);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteMessage (@PathVariable("id")int id){
        return messageService.deleteMessage(id);
    }
}
