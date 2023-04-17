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

    @OneToOne(fetch = FetchType.EAGER)
    private Korisnik korisnik;


    public Recenzija(int ocena, String tekst, Date datumRecenzije, Korisnik korisnik) {
        this.ocena = ocena;
        this.tekst = tekst;
        this.datumRecenzije = datumRecenzije;
        this.korisnik = korisnik;
    }

    public Recenzija() {

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

    public Date getDatumRecenzije() {
        return datumRecenzije;
    }

    public void setDatumRecenzije(Date datumRecenzije) {
        this.datumRecenzije = datumRecenzije;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    @Override
    public String toString() {
        return "Recenzija{" +
                "ocena=" + ocena +
                ", tekst='" + tekst + '\'' +
                ", datumRecenzije=" + datumRecenzije +
                ", korisnik=" + korisnik +
                '}';
    }
}
