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
public class StavkaPolice implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "stavkapolice", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="recenzija_id")
    private Set<Recenzija> recenzije = new HashSet<>();

    @OneToOne
    @JoinColumn(name="knjiga_id")
    private Knjiga knjiga;

    public StavkaPolice(String recenzija, Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public StavkaPolice() {

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
                "recenzije='" + recenzije + '\'' +
                ", knjiga=" + knjiga +
                '}';
    }
}
