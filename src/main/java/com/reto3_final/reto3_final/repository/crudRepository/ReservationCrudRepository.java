package com.reto3_final.reto3_final.repository.crudRepository;

import com.reto3_final.reto3_final.entity.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
    // ----producto con mayor cantidad de reserva -----
   // @Query("SELECT c.bike, COUNT(c.bike) FROM Reservation AS c GROUP BY c.bike ORDER BY COUNT(c.bike) DESC")
    //public List<Object[]>countTotalReservationByBike();

    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC")
    public List<Object[]>countTotalReservationsByClients();

    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date dateOne,Date dateTwo);

    public List<Reservation> findAllByStatus(String status);



}
