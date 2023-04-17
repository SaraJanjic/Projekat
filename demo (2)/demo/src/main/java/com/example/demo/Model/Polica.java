package com.example.demo.Model;

import jakarta.persistence.*;

import java.io.Serializable;

public class Polica implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @JoinColumn(name="polica_id")
    private Long id;

    private String  naziv;

    private Boolean oznakaPolice;

    @OneToMany(mappedBy = "polica", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private StavkaPolice stavka;

    public Polica(String naziv, Boolean oznakaPolice, StavkaPolice stavka) {
        this.naziv = naziv;
        this.oznakaPolice = oznakaPolice;
        this.stavka = stavka;
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

    public StavkaPolice getStavka() {
        return stavka;
    }

    public void setStavka(StavkaPolice stavka) {
        this.stavka = stavka;
    }


    @Override
    public String toString() {
        return "Polica{" +
                "naziv='" + naziv + '\'' +
                ", oznakaPolice=" + oznakaPolice +
                ", stavka=" + stavka +
                '}';
    }
}
