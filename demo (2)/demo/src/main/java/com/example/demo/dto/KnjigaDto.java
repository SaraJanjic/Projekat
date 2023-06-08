package com.example.demo.dto;

import com.example.demo.Entity.Autor;
import com.example.demo.Entity.Knjiga;
import com.example.demo.Entity.Zanr;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public class KnjigaDto {
    private Long id; //da li treba
    private String naslov;
    private String isbn; //da li treba
    private LocalDate datumObjavljivanja;
    private int brStrana;
    private String opis;
    private String naslovnaSlika;
    private Zanr zanr;
    private Double ocena;//double
    private Autor autor;


    public KnjigaDto(Long id, String naslov, String isbn, LocalDate datumObjavljivanja, int brStrana, String opis, String naslovnaSlika, Zanr zanr, Double ocena, Autor autor) {
        this.id = id;
        this.naslov = naslov;
        this.isbn = isbn;
        this.datumObjavljivanja = datumObjavljivanja;
        this.brStrana = brStrana;
        this.opis = opis;
        this.naslovnaSlika = naslovnaSlika;
        this.zanr = zanr;
        this.ocena = ocena;
        this.autor = autor;
    }

    public KnjigaDto(Knjiga k) {
        this.id = k.getId();
        this.naslov = k.getNaslov();
        this.isbn = k.getISBN();
        this.datumObjavljivanja = k.getDatumObjavljivanja();
        this.brStrana = k.getBrStrana();
        this.opis = k.getOpis();
        this.naslovnaSlika = k.getNaslovnaSlika();
        this.zanr = k.getZanr();
        this.ocena = k.getOcena();
        this.autor = k.getAutor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getDatumObjavljivanja() {
        return datumObjavljivanja;
    }

    public void setDatumObjavljivanja(LocalDate datumObjavljivanja) {
        this.datumObjavljivanja = datumObjavljivanja;
    }

    public int getBrStrana() {
        return brStrana;
    }

    public void setBrStrana(int brStrana) {
        this.brStrana = brStrana;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getNaslovnaSlika() {
        return naslovnaSlika;
    }

    public void setNaslovnaSlika(String naslovnaSlika) {
        this.naslovnaSlika = naslovnaSlika;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }

    public Double getOcena() {
        return ocena;
    }

    public void setOcena(Double ocena) {
        this.ocena = ocena;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

}
