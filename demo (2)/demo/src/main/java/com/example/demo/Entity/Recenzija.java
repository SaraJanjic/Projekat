package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Recenzija implements Serializable {


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private int ocena;

    private String tekst;

    private Date datumRecenzije;

    @OneToOne
    @JoinColumn(name = "korisnik_id")
    private Korisnik korisnik;



}
