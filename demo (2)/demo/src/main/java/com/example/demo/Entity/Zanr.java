package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Zanr implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String nazivZanra;

    public Zanr(String nazivZanra) {
        this.nazivZanra = nazivZanra;
    }

    public Zanr() {

    }

    public String getNazivZanra() {
        return nazivZanra;
    }

    public void setNazivZanra(String nazivZanra) {
        this.nazivZanra = nazivZanra;
    }

    @Override
    public String toString() {
        return "Zanr{" +
                "nazivZanra='" + nazivZanra + '\'' +
                '}';
    }
}
