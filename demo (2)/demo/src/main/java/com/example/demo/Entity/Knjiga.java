package com.example.demo.Entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Knjiga implements Serializable {


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String naslov;

    private int ISBN;

    @DateTimeFormat
    private Date datumObjavljivanja;

    private int brStrana;

    private String opis;

    private String naslovnaSlika;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="zanr_id")
    private Zanr zanr;


    private Float ocena;


    @ManyToOne
    @JoinColumn(name="autor_id")
    private Autor autor;

}
