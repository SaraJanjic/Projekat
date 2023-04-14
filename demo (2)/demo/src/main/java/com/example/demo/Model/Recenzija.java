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


    public Recenzija(int ocena, String tekst, Date datumRecenzije, Korisnik korisnik) {
        this.ocena = ocena;
        this.tekst = tekst;
        this.datumRecenzije = datumRecenzije;
        this.korisnik = korisnik;
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
