package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

import java.io.Serializable;


@Entity
public class Autor extends Korisnik implements Serializable {

    @Column
    private boolean aktivnost;

    public Autor(String ime, String prezime, String userName, String email, String lozinka, String opis, String slikaKorisnika, Uloga uloga, boolean aktivnost) {
        super(ime, prezime, userName, email, lozinka, opis, slikaKorisnika, uloga);
        this.aktivnost = aktivnost;
    }
}
