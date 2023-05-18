package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Recenzija implements Serializable {


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int ocena;

    @Column
    private String tekst;

    //@DateTimeFormat
    private LocalDate datumRecenzije;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "korisnik_id")
    private Korisnik korisnik;


    public Recenzija(int ocena, String tekst){ //LocalDate datumRecenzije) {
        this.ocena = ocena;
        this.tekst = tekst;
        //this.datumRecenzije = datumRecenzije;
    }
}
