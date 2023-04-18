package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

enum Uloga{CITALAC, AUTOR, ADMINISTRATOR}

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Korisnik implements Serializable{

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ime;
    @Column
    private String prezime;

    @Column(unique = true)
    private String userName;

    @Column(unique = true)
    private String email;

    @Column
    private String lozinka;

    @Column
    private String datumRodjenja;

    @Column
    private String opis;

    @Column
    private String slikaKorisnika;

    @Column
    @Enumerated(EnumType.STRING)
    private Uloga uloga;

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

    public String getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(String datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    /*
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
                //", slikaKorisnika=" + slikaKorisnika +
                ", uloga=" + uloga +
                '}';
    }
    */
}
