package com.example.demo.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;

public class Autor extends Korisnik{

    private boolean aktivnost;

    @OneToMany(mappedBy = "autor", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<Knjiga> knjige = new ArrayList<>();

    public Autor(String ime, String prezime, String userName, String email, String lozinka, Date datumRodjenja, String opis, Image slikaKorisnika, Uloga uloga, boolean aktivnost) {
        super(ime, prezime, userName, email, lozinka, datumRodjenja, opis, slikaKorisnika, uloga);
        this.aktivnost = aktivnost;

    }

    public boolean isAktivnost() {
        return aktivnost;
    }

    public void setAktivnost(boolean aktivnost) {
        this.aktivnost = aktivnost;
    }

    public ArrayList<Knjiga> getKnjige() {
        return knjige;
    }

    public void setKnjige(ArrayList<Knjiga> knjige) {
        this.knjige = knjige;
    }


    @Override
    public String toString() {
        return "Autor{" +
                "aktivnost=" + aktivnost +
                ", knjige=" + knjige +
                '}';
    }
}
