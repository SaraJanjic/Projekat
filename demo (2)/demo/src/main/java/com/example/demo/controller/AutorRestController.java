package com.example.demo.controller;

import com.example.demo.Entity.Autor;
import com.example.demo.Entity.Korisnik;
import com.example.demo.Entity.ZahtevZaAktivacijuAutora;
import com.example.demo.Repository.AutorRepository;
import com.example.demo.dto.ZahtevZaAktivacijuAutoraDTO;
import com.example.demo.service.AutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@RestController
public class AutorRestController {
    private final AutorRepository autorRepository;
    private AutorService autorService;

    public AutorRestController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }



}
