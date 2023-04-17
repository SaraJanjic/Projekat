package com.example.demo.Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Knjiga implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String naslov;

    private int ISBN;

    private Date datumObjavljivanja;

    private int brStrana;

    private String opis;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="zanr_id")
    private Zanr zanr;

    private Float ocena;

    /*
    @OneToOne
    @JoinColumn(name="autor_id")
    private Autor autor;
*/

    public Knjiga(String naslov, int ISBN, Date datumObjavljivanja, int brStrana, String opis, Zanr zanr, Float ocena) {
        this.naslov = naslov;
        this.ISBN = ISBN;
        this.datumObjavljivanja = datumObjavljivanja;
        this.brStrana = brStrana;
        this.opis = opis;
        this.zanr = zanr;
        this.ocena = ocena;
    }

    public Knjiga() {

    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public Date getDatumObjavljivanja() {
        return datumObjavljivanja;
    }

    public void setDatumObjavljivanja(Date datumObjavljivanja) {
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

    public Zanr getZanr() {
        return zanr;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }

    public Float getOcena() {
        return ocena;
    }

    public void setOcena(Float ocena) {
        this.ocena = ocena;
    }

    @Override
    public String toString() {
        return "Knjiga{" +
                "naslov='" + naslov + '\'' +
                ", ISBN=" + ISBN +
                ", datumObjavljivanja=" + datumObjavljivanja +
                ", brStrana=" + brStrana +
                ", opis='" + opis + '\'' +
                ", zanr=" + zanr +
                ", ocena=" + ocena +
                '}';
    }
}
