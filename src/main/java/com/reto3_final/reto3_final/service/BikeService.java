package com.reto3_final.reto3_final.service;

import com.reto3_final.reto3_final.entity.Bike;
import com.reto3_final.reto3_final.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@Service
public class BikeService {
    @Autowired
    private BikeRepository bikeRepository;

    public List<Bike> getAll(){
        return bikeRepository.getAll();
    }

    public Optional<Bike> getBikes(int id){
        return bikeRepository.getBikes(id);
    }

    public Bike save(Bike bikes){
        if(bikes.getId()==null){
            return bikeRepository.save(bikes);
        } else {
            Optional<Bike> e=bikeRepository.getBikes(bikes.getId());
            if(e.isEmpty()){
                return bikeRepository.save(bikes);
            } else {
                return bikes;
            }
        }

    }

    public Bike update(Bike bike) {
        if (bike.getId() != null) {
            Optional<Bike> q = bikeRepository.getBikes(bike.getId());
            if (!q.isEmpty()) {
                if (bike.getName() != null) {
                    q.get().setName(bike.getName());
                    }
                    if (bike.getBrand() != null) {
                        q.get().setBrand(bike.getBrand());
                    }
                    if (bike.getYear() != null) {
                        q.get().setYear(bike.getYear());
                    }

                    if (bike.getDescription() != null) {
                        q.get().setDescription(bike.getDescription());
                    }

                    if (bike.getCategory() != null) {
                        q.get().setCategory(bike.getCategory());
                    }
                    bikeRepository.save(q.get());
                    return (q.get());
                } else {
                    return bike;
                }
            } else {
                return bike;
            }
    }


    /*   ******* reto2 con is present ***********
        public Bike update(Bike bike){
        if(bike.getIdReservation()!=null){
            Optional<Bike> q = bikeRepository.getBike(bike.getIdReservation());
            if(q.isPresent()){
                if(bike.getYear()!=null){
                    q.get().setYear(bike.getYear());
                }
                if(bike.getBrand()!=null){
                    q.get().setBrand(bike.getBrand());
                }
                if(bike.getCategory()!=null){
                    q.get().setCategory(bike.getCategory());
                }

                bikeRepository.save(q.get());
                return q.get();

            }else {
                return bike;
            }

        }else {
            return bike;
        }
    }
    *********************************************************************
    */


    /* *********** delete reto 2 **********************
        public boolean delete(int id){
        Boolean flag=false;
        Optional<Bike> bike=bikeRepository.getBike(id);
        if(bike.isPresent()){
            bikeRepository.delete(bike.get());
            flag=true;
        }

        return flag;
    }
    ********************************************************
    */


    public boolean deleteBike(int id) {
        boolean d = getBikes(id).map(bike -> {
            bikeRepository.delete(bike);
            return true;
        }).orElse(false);
        return d;
    }
}

