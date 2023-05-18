package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Polica implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String  naziv;

    private Boolean oznakaPolice;

    public Polica(String naziv, Boolean oznakaPolice) {
        this.naziv = naziv;
        this.oznakaPolice = oznakaPolice;
    }

    public Polica() {

    }
}
