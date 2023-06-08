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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="knjiga_id")
    private Knjiga knjiga;

    @OneToOne
    @JoinColumn(name = "recenzija_id")
    private Recenzija recenzija;

//    @ManyToMany
//    //@JoinColumn(name = "polica_id")
//    @JoinTable(name = "police",
//            joinColumns = @JoinColumn(name = "polica_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "stavkaPolice_id", referencedColumnName = "id"))
//    //private Polica polica;
//    private Set<Polica> police = new HashSet<>();

    public StavkaPolice(Knjiga knjiga, Recenzija recenzija) {
        this.knjiga = knjiga;
        this.recenzija = recenzija;
    }

    public StavkaPolice() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    public Recenzija getRecenzija() {
        return recenzija;
    }

    public void setRecenzija(Recenzija recenzija) {
        this.recenzija = recenzija;
    }

//    public Set<Polica> getPolice() {
//        return police;
//    }
//
//    public void setPolice(Set<Polica> police) {
//        this.police = police;
//    }
}
