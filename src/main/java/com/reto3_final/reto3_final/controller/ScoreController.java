package com.reto3_final.reto3_final.controller;


import com.reto3_final.reto3_final.entity.Bike;
import com.reto3_final.reto3_final.entity.Score;
import com.reto3_final.reto3_final.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score postScore(@RequestBody Score data){
        return scoreService.save(data);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score update(@RequestBody Score score){
        return scoreService.update(score);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteScore (@PathVariable("id")int id){
        return scoreService.deleteScore(id);
    }
}
