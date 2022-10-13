package com.reto3_final.reto3_final.repository;

import com.reto3_final.reto3_final.entity.Reservation;
import com.reto3_final.reto3_final.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }

    public Optional<Reservation> getReservation(Integer idReservation){
        return reservationCrudRepository.findById(idReservation);
    }

    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }
}
