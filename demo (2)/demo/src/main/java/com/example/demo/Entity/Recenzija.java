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

    public Recenzija() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public LocalDate getDatumRecenzije() {
        return datumRecenzije;
    }

    public void setDatumRecenzije(LocalDate datumRecenzije) {
        this.datumRecenzije = datumRecenzije;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
}
