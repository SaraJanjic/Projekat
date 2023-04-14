package com.example.demo.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

public class Polica {

    private String  naziv;

/*
    private String oznakaPolice;

 */
    @OneToMany(mappedBy = "polica", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private StavkaPolice stavka;







}
