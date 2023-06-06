package com.example.demo.dto;

public class DodavanjeKnjigeNaPolicuDto {

    private String nazivKnjige;

    private  String nazivPolice;

    private boolean jelPrimarna;

    public DodavanjeKnjigeNaPolicuDto(String nazivKnjige, String nazivPolice, boolean jelPrimarna) {
        this.nazivKnjige = nazivKnjige;
        this.nazivPolice = nazivPolice;
        this.jelPrimarna = jelPrimarna;
    }

    public String getNazivKnjige() {
        return nazivKnjige;
    }

    public void setNazivKnjige(String nazivKnjige) {
        this.nazivKnjige = nazivKnjige;
    }

    public String getNazivPolice() {
        return nazivPolice;
    }

    public void setNazivPolice(String nazivPolice) {
        this.nazivPolice = nazivPolice;
    }

    public boolean isJelPrimarna() {
        return jelPrimarna;
    }

    public void setJelPrimarna(boolean jelPrimarna) {
        this.jelPrimarna = jelPrimarna;
    }
}
