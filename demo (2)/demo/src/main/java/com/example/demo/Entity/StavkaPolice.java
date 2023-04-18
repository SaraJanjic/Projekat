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

    @OneToOne
    @JoinColumn(name="knjiga_id")
    private Knjiga knjiga;

    @OneToOne
    @JoinColumn(name = "recenzija_id")
    private Recenzija recenzija;

    @OneToOne
    @JoinColumn(name = "polica_id")
    private Polica polica;


}
