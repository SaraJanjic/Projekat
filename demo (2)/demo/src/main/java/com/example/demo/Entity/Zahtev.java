package com.example.demo.Entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

enum Status{NA_CEKANJU, ODOBREN, ODBIJEN}

@Entity
public class Zahtev implements Serializable {


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefon;

    @Column(nullable = false)
    private String poruka;

    @DateTimeFormat
    private Date datumZahteva;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;


}
