package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Date;

enum Status{NA_CEKANJU, ODOBREN, ODBIJEN}

@Entity
public class Zahtev implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String telefon;

    private String poruka;

    private Date datumZahteva;


    public Zahtev(String email, String telefon, String poruka, Date datumZahteva) {
        this.email = email;
        this.telefon = telefon;
        this.poruka = poruka;
        this.datumZahteva = datumZahteva;
    }

    public Zahtev() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public Date getDatumZahteva() {
        return datumZahteva;
    }

    public void setDatumZahteva(Date datumZahteva) {
        this.datumZahteva = datumZahteva;
    }

    @Override
    public String toString() {
        return "Zahtev{" +
                "email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                ", poruka='" + poruka + '\'' +
                ", datumZahteva=" + datumZahteva +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
