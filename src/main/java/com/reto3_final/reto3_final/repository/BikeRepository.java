package com.reto3_final.reto3_final.repository;

import com.reto3_final.reto3_final.entity.Bike;
import com.reto3_final.reto3_final.entity.Category;
import com.reto3_final.reto3_final.repository.crudRepository.BikeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BikeRepository {
    @Autowired
    private BikeCrudRepository bikeCrudRepository;

    public List<Bike> getAll(){
        return (List<Bike>) bikeCrudRepository.findAll();
    }

    public Bike save(Bike bikes){
        return bikeCrudRepository.save(bikes);
    }

    public Optional<Bike> getBikes(Integer id){
        return bikeCrudRepository.findById(id);
    }

    public void delete (Bike bike){
        bikeCrudRepository.delete(bike);
    }
}

