package com.example.demo.Entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

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

    public Zahtev(String email, String telefon, String poruka, Status status) {
        this.email = email;
        this.telefon = telefon;
        this.poruka = poruka;
        this.status = status;
    }

    public Zahtev() {

    }
}
