package com.reto3_final.reto3_final.service;

import com.reto3_final.reto3_final.entity.Reservation;
import com.reto3_final.reto3_final.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int idReservation){
        return reservationRepository.getReservation(idReservation);
    }

    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> e=reservationRepository.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public Reservation  update(Reservation  reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation > q = reservationRepository.getReservation(reservation.getIdReservation());
            if(!q.isEmpty()){
                if(reservation.getStartDate()!=null){
                    q.get().setStartDate(reservation.getStartDate());
                }

                if(reservation.getDevolutionDate()!=null){
                    q.get().setDevolutionDate(reservation.getDevolutionDate());
                }

                if (reservation.getStatus()!=null){
                    q.get().setStatus(reservation.getStatus());
                }

                reservationRepository.save(q.get());
                return q.get();

            }else {
                return reservation;
            }

        }else {
            return reservation;
        }
    }


    /*public boolean delete(int idReservation){
         Boolean flag=false;
        Optional<Reservation > reservation= reservationRepository.getReservation(idReservation);
        if(reservation.isPresent()){
            reservationRepository.delete(reservation.get());
            flag=true;
        }

        return flag;
    }*/

    public boolean deleteReservation(int id){
        Boolean d = getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return d;
    }
}

