package com.reto3_final.reto3_final.controller;


import com.reto3_final.reto3_final.entity.Bike;
import com.reto3_final.reto3_final.entity.UsuaryAdmin;
import com.reto3_final.reto3_final.service.UsuaryAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UsuaryAdminController {
    @Autowired
    private UsuaryAdminService usuaryAdminService;

    @GetMapping("/all")
    public List<UsuaryAdmin> getAdmins(){
        return usuaryAdminService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuaryAdmin postAdmin(@RequestBody UsuaryAdmin usuaryAdmin){
        return usuaryAdminService.save(usuaryAdmin);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuaryAdmin update(@RequestBody UsuaryAdmin usuaryAdmin){
        return usuaryAdminService.update(usuaryAdmin);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteUsuaryAdmin (@PathVariable("id")int id){
        return usuaryAdminService.deleteUsuaryAdmin(id);
    }

}
