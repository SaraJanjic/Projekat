package com.example.demo.dto;

import com.example.demo.Entity.Korisnik;
import com.example.demo.Entity.Polica;
import com.example.demo.Entity.Uloga;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class KorisnikDto {

    private Long id;

    private String ime;

    private String prezime;

    private String userName;

    private String email;

    private String lozinka; //mislim da ne treba u dto?

    private Date datumRodjenja;//Local date

    private String opis;

    private String slikaKorisnika;

    private Uloga uloga;

    private Set<Polica> korisnickePolice = new HashSet<>();

    public KorisnikDto(Long id, String ime, String prezime, String userName, String email, String lozinka, Date datumRodjenja, String opis, String slikaKorisnika, Uloga uloga, Set<Polica> korisnickePolice) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.userName = userName;
        this.email = email;
        this.lozinka = lozinka;
        this.datumRodjenja = datumRodjenja;
        this.opis = opis;
        this.slikaKorisnika = slikaKorisnika;
        this.uloga = uloga;
        this.korisnickePolice = korisnickePolice;
    }

    public KorisnikDto(Korisnik korisnik) {
        this.id = korisnik.getId();
        this.ime = korisnik.getIme();
        this.prezime = korisnik.getPrezime();
        this.userName = korisnik.getUserName();
        this.email = korisnik.getEmail();
        this.lozinka = korisnik.getLozinka();
        this.datumRodjenja = korisnik.getDatumRodjenja();
        this.opis = korisnik.getOpis();
        this.slikaKorisnika = korisnik.getSlikaKorisnika();
        this.uloga = korisnik.getUloga();
        this.korisnickePolice = korisnik.getKorisnickePolice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getSlikaKorisnika() {
        return slikaKorisnika;
    }

    public void setSlikaKorisnika(String slikaKorisnika) {
        this.slikaKorisnika = slikaKorisnika;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }

    public Set<Polica> getKorisnickePolice() {
        return korisnickePolice;
    }

    public void setKorisnickePolice(Set<Polica> korisnickePolice) {
        this.korisnickePolice = korisnickePolice;
    }
}
