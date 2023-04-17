package com.example.demo.Model;

import jakarta.persistence.*;

import java.io.Serializable;

public class StavkaPolice implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "stavkapolice", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="recenzija_id")
    private String recenzija;

    @OneToOne
    @JoinColumn(name="knjiga_id")
    private Knjiga knjiga;

    public StavkaPolice(String recenzija, Knjiga knjiga) {
        this.recenzija = recenzija;
        this.knjiga = knjiga;
    }

    public String getRecenzija() {
        return recenzija;
    }

    public void setRecenzija(String recenzija) {
        this.recenzija = recenzija;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    @Override
    public String toString() {
        return "StavkaPolice{" +
                "recenzija='" + recenzija + '\'' +
                ", knjiga=" + knjiga +
                '}';
    }
}
