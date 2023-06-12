package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Polica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;

    private Boolean oznakaPolice;
    //@ManyToMany
    //private List<Knjiga> knjige;

    @ManyToMany
    @JoinTable(name = "stavke",
            joinColumns = @JoinColumn(name = "stavka_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "polica_id", referencedColumnName = "id"))
    private Set<StavkaPolice> stavke = new HashSet<>();

    public Polica(Long id, String naziv, Boolean oznakaPolice, Set<StavkaPolice> stavke) {
        this.id = id;
        this.naziv = naziv;
        this.oznakaPolice = oznakaPolice;
        this.stavke = stavke;
    }

    public Polica() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Boolean getOznakaPolice() {
        return oznakaPolice;
    }

    public void setOznakaPolice(Boolean oznakaPolice) {
        this.oznakaPolice = oznakaPolice;
    }

    public Set<StavkaPolice> getStavke() {
        return stavke;
    }

    public void setStavke(Set<StavkaPolice> stavke) {
        this.stavke = stavke;
    }
}
