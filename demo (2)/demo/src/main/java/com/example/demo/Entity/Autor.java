package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Autor extends Korisnik implements Serializable {

    @Column
    private boolean aktivnost;

    @OneToMany(mappedBy = "autor", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Knjiga> knjige = new HashSet<>();

    public Autor(String ime, String prezime, String userName, String email, String lozinka, String datumRodjenja, String opis, Uloga uloga, boolean aktivnost) {
        super(ime, prezime, userName, email, lozinka, datumRodjenja, opis, uloga);
        this.aktivnost = aktivnost;

    }

    public Autor() {

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
