package com.reto3_final.reto3_final.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "message")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "bikeId")
    @JsonIgnoreProperties({"messages","reservations"})
    private Bike bike;

    @ManyToOne
    @JoinColumn(name = "clientIdClient")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;

    public Message(){}

    public Message(Integer idMessage, String messageText, Bike bike, Client client) {
        this.idMessage = idMessage;
        this.messageText = messageText;
        this.bike = bike;
        this.client = client;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

