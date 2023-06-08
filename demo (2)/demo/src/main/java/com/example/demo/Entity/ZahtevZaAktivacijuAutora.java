package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ZahtevZaAktivacijuAutora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private int brojTelefona;
    private String dodatnaPoruka;
    private String ime;
    private String prezime;

    public ZahtevZaAktivacijuAutora(Long id, String email, int brojTelefona, String dodatnaPoruka, String ime, String prezime) {
        this.id = id;
        this.email = email;
        this.brojTelefona = brojTelefona;
        this.dodatnaPoruka = dodatnaPoruka;
        this.ime = ime;
        this.prezime = prezime;
    }

    public ZahtevZaAktivacijuAutora() {

    }


    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(int brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getDodatnaPoruka() {
        return dodatnaPoruka;
    }

    public void setDodatnaPoruka(String dodatnaPoruka) {
        this.dodatnaPoruka = dodatnaPoruka;
    }
}
