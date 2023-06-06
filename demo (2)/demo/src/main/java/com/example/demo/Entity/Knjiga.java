package com.example.demo.Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Knjiga implements Serializable {


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String naslov;

    //string
    private String ISBN;


    private LocalDate datumObjavljivanja;

    private int brStrana;

    private String opis;

    private String naslovnaSlika;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="zanr_id")
    private Zanr zanr;

    private Double ocena;//double


    @ManyToOne
    @JoinColumn(name="autor_id")
    private Autor autor;


    public Knjiga(String naslov, String ISBN, int brStrana, String opis, String naslovnaSlika, Double ocena) {
        this.naslov = naslov;
        this.ISBN = ISBN;
        this.brStrana = brStrana;
        this.opis = opis;
        this.naslovnaSlika = naslovnaSlika;
        this.ocena = ocena;
    }

    public Knjiga() {

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

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
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

    public void setAutor() {
        this.autor = autor;
    }
}
