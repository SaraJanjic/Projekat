package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Korisnik implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ime;

    @Column(nullable = false)
    private String prezime;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String lozinka;

    @Column
    @DateTimeFormat
    private Date datumRodjenja;//Local date

    @Column
    private String opis;

    @Column
    private String slikaKorisnika;

    @Column
    @Enumerated(EnumType.STRING)
    private Uloga uloga;

    //lista polica
    @ManyToMany
    @JoinTable(name = "police",
            joinColumns = @JoinColumn(name = "polica_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "korisnik_id", referencedColumnName = "id"))
    private Set<Polica> korisnickePolice = new HashSet<>();


    public Korisnik(String ime, String prezime, String userName, String email, String lozinka, String opis, String slikaKorisnika, Uloga uloga) {
        this.ime = ime;
        this.prezime = prezime;
        this.userName = userName;
        this.email = email;
        this.lozinka = lozinka;
        this.opis = opis;
        this.slikaKorisnika = slikaKorisnika;
        this.uloga = uloga;
    }

    public Korisnik() {

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