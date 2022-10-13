package com.reto3_final.reto3_final.controller;

import com.reto3_final.reto3_final.entity.Bike;
import com.reto3_final.reto3_final.entity.Category;
import com.reto3_final.reto3_final.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/Bike")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @GetMapping("/all")
    public List<Bike> getBikes() {
        return bikeService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike postBikes(@RequestBody Bike bikes) {
        return bikeService.save(bikes);
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike postBikes2(@RequestBody Bike bikes) {
        return bikeService.save(bikes);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike update(@RequestBody Bike bike) {
        return bikeService.update(bike);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteBike(@PathVariable("id") int id) {
        return bikeService.deleteBike(id);
    }

}

