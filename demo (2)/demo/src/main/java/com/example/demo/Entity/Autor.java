package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

import java.io.Serializable;


@Entity
public class Autor extends Korisnik implements Serializable {

    @Column
    private boolean aktivnost;

}
