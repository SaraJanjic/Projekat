package com.example.demo.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Autor extends Korisnik{

    @Column
    private boolean aktivnost;

    @OneToMany(mappedBy = "autor", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Knjiga> knjige = new HashSet<>();

    public Autor(String ime, String prezime, String userName, String email, String lozinka, String datumRodjenja, String opis, Image slikaKorisnika, Uloga uloga, boolean aktivnost) {
        super(ime, prezime, userName, email, lozinka, datumRodjenja, opis, slikaKorisnika, uloga);
        this.aktivnost = aktivnost;

    }

    public boolean isAktivnost() {
        return aktivnost;
    }

    public void setAktivnost(boolean aktivnost) {
        this.aktivnost = aktivnost;
    }


    public Set<Knjiga> getKnjige() {
        return knjige;
    }

    public void setKnjige(Set<Knjiga> knjige) {
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
