package com.example.demo.dto;

import com.example.demo.Entity.Zanr;

public class ZanrDto {
    private Long id;
    private String NazivZanra;

    public ZanrDto(Long id, String nazivZanra) {
        this.id = id;
        NazivZanra = nazivZanra;
    }

    public ZanrDto(Zanr zanr){
        this.id = zanr.getId();
        NazivZanra = zanr.getNazivZanra();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazivZanra() {
        return NazivZanra;
    }

    public void setNazivZanra(String nazivZanra) {
        NazivZanra = nazivZanra;
    }
}
