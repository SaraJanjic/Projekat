package com.example.demo.Model;

import jakarta.persistence.*;

import java.io.Serializable;

public class Zanr implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String nazivZanra;

    public Zanr(String nazivZanra) {
        this.nazivZanra = nazivZanra;
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
