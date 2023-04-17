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
public class Polica implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @JoinColumn(name="polica_id")
    private Long id;

    private String  naziv;

    private Boolean oznakaPolice;

    @OneToMany(mappedBy = "polica", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StavkaPolice> stavke = new HashSet<>();

    public Polica(String naziv, Boolean oznakaPolice, StavkaPolice stavka) {
        this.naziv = naziv;
        this.oznakaPolice = oznakaPolice;
    }

    public Polica() {

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

    @Override
    public String toString() {
        return "Polica{" +
                "naziv='" + naziv + '\'' +
                ", oznakaPolice=" + oznakaPolice +
                ", stavka=" + stavke +
                '}';
    }
}
