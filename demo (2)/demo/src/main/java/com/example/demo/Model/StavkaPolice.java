package com.example.demo.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

public class StavkaPolice {

    @OneToMany(mappedBy = "stavkapolice", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private String recenzija;

    @OneToMany(mappedBy = "stavkapolice", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
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
