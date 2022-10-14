package com.reto3_final.reto3_final.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "bike")
public class Bike implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    @Column(name = "years")
    private Integer year;
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryId")                 //como almacena Id de categoria
    @JsonIgnoreProperties("bikes")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "bike")  //
    @JsonIgnoreProperties({"client","bikes"})
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "bike")      //PERSIST
    @JsonIgnoreProperties({"messages","bikes"})   //client bikes
    private List<Reservation> reservations;

/*
    OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "bike")      //mappea reservations
    @JsonIgnoreProperties({"bike","client"})
    private List<Reservation> reservations;

 */
    public Bike(){}

    public Bike(Integer id, String name, String brand, Integer year, String description, Category category, List<Message> messages, List<Reservation> reservations) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.year = year;
        this.description = description;
        this.category = category;
        this.messages = messages;
        this.reservations = reservations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}



