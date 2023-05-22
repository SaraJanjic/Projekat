package com.example.demo.dto;

import com.example.demo.Entity.Polica;

public class PolicaDto {
    private Long id;

    private String  naziv;

    private Boolean oznakaPolice;

    public PolicaDto(Long id, String naziv, Boolean oznakaPolice) {
        this.id = id;
        this.naziv = naziv;
        this.oznakaPolice = oznakaPolice;
    }

    public PolicaDto(Polica p) {
        this.id = p.getId();
        this.naziv = p.getNaziv();
        this.oznakaPolice = p.getOznakaPolice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
