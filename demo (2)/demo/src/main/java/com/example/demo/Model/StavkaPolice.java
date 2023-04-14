package com.example.demo.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

public class StavkaPolice {

    @OneToMany(mappedBy = "stavkapolice", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private String recenzija;

    @OneToMany(mappedBy = "stavkapolice", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Knjiga knjiga;



}
