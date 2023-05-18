package com.example.demo.dto;

import com.example.demo.Entity.Korisnik;
import com.example.demo.Entity.Polica;
import com.example.demo.Entity.Uloga;
import jakarta.persistence.*;

import java.time.LocalDate;

public class RegistracijaDto {

    private Long id;

    private String ime;

    private String prezime;

    private String email;

    private String userName;

    private String  lozinka;

    public RegistracijaDto(String ime, String prezime, String email, String userName, String lozinka) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.userName = userName;
        this.lozinka = lozinka;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
}