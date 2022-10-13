package com.reto3_final.reto3_final.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuaryadmin")
public class UsuaryAdmin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String password;


    public UsuaryAdmin(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UsuaryAdmin(){
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

