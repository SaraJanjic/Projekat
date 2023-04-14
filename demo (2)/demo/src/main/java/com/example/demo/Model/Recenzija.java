package com.example.demo.Model;

import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;

import java.util.Date;

public class Recenzija {

    private int ocena;

    private String tekst;

    private Date datumRecenzije;

    @OneToOne(fetch = FetchType.EAGER)
    private Korisnik korisnik;








}
