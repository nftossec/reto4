package com.reto3_final.reto3_final.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "score")
public class Score implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;     //idScore
    private Integer score;          //stars
    private String message;         //messageText


    @OneToOne
    @JsonIgnoreProperties("score")
    private Reservation reservation;


    public Score(){}


    public Score(Integer score, String message, Reservation reservation) {
        this.score = score;
        this.message = message;
        this.reservation = reservation;
    }


    public Score(Integer id, Integer score, String message, Reservation reservation) {
        this.id = id;
        this.score = score;
        this.message = message;
        this.reservation = reservation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}

