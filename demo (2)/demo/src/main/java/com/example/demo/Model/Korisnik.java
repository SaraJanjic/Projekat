package com.example.demo.Model;

import jakarta.persistence.Column;

import java.awt.*;
import java.util.Date;

enum Uloga{CITALAC, AUTOR, ADMINISTRATOR};

public class Korisnik {

    @Column
    private String ime;
    @Column
    private String prezime;

    @Column(unique = true)
    private String userName;
    @Column(unique = true)
    private String email;
    private String lozinka;

    @Column
    private Date datumRodjenja;

    @Column
    private String opis;

    private Image slikaKorisnika;

    private Uloga uloga;

    public Korisnik(String ime, String prezime, String userName, String email, String lozinka, Date datumRodjenja, String opis, Image slikaKorisnika, Uloga uloga) {
        this.ime = ime;
        this.prezime = prezime;
        this.userName = userName;
        this.email = email;
        this.lozinka = lozinka;
        this.datumRodjenja = datumRodjenja;
        this.opis = opis;
        this.slikaKorisnika = slikaKorisnika;
        this.uloga = uloga;
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

    public Image getSlikaKorisnika() {
        return slikaKorisnika;
    }

    public void setSlikaKorisnika(Image slikaKorisnika) {
        this.slikaKorisnika = slikaKorisnika;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }


    @Override
    public String toString() {
        return "Korisnik{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", datumRodjenja=" + datumRodjenja +
                ", opis='" + opis + '\'' +
                ", slikaKorisnika=" + slikaKorisnika +
                ", uloga=" + uloga +
                '}';
    }
}
