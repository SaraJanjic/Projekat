package com.example.demo.Model;

import java.util.SplittableRandom;

public class Zanr {

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
