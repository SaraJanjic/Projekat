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
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String  naziv;

    private Boolean oznakaPolice;
    @ManyToMany
    private List<Knjiga> knjige;

    public List<Knjiga> getKnjige() {
        return knjige;
    }

    public void setKnjige(List<Knjiga> knjige) {
        this.knjige = knjige;
    }

    public Polica(String naziv, Boolean oznakaPolice) {
        this.naziv = naziv;
        this.oznakaPolice = oznakaPolice;
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
}
