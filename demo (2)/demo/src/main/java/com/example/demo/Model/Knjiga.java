package com.example.demo.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.ManyToAny;

import java.util.Date;

public class Knjiga {

    private String naslov;

    private int ISBN;

    private Date datumObjavljivanja;

    private int brStrana;

    private String opis;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="zanr_knjige")
    private Zanr zanr;

    private Float ocena;


    public Knjiga() {
    }
}
