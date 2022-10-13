package com.reto3_final.reto3_final.controller;


import com.reto3_final.reto3_final.entity.Bike;
import com.reto3_final.reto3_final.entity.Reservation;
import com.reto3_final.reto3_final.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return reservationService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation postReservation(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation postReservation2(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return reservationService.update(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReservation (@PathVariable("id")int id){
        return reservationService.deleteReservation(id);
    }
}
