package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

import javax.lang.model.util.SimpleElementVisitor7;
import java.io.Serializable;
import java.util.Date;
import java.util.Stack;

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
    @DateTimeFormat
    private Date datumRodjenja;

    @Column
    private String opis;

    @Column
    private String slikaKorisnika;

    @Column
    @Enumerated(EnumType.STRING)
    private Uloga uloga;


}
