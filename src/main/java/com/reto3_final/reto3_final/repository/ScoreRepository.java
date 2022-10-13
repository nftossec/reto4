package com.reto3_final.reto3_final.repository;

import com.reto3_final.reto3_final.entity.Message;
import com.reto3_final.reto3_final.entity.Score;
import com.reto3_final.reto3_final.repository.crudRepository.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<Score> getAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }

    public Optional<Score> getScore(Integer data){
        return scoreCrudRepository.findById(data);
    }

    public Score save(Score data){
        return scoreCrudRepository.save(data);
    }

    public void delete(Score score){
        scoreCrudRepository.delete(score);
    }


}

