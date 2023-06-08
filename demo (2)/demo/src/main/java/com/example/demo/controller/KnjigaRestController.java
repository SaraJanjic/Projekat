package com.example.demo.controller;

import com.example.demo.Entity.Knjiga;
import com.example.demo.Repository.KnjigaRepository;
import com.example.demo.service.KnjigaService;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class KnjigaRestController {
    private KnjigaService knjigaService;
    private final KnjigaRepository knjigaRepository; //final je da se ne moze menjati

    public KnjigaRestController(KnjigaRepository knjigaRepository) {
        this.knjigaRepository = knjigaRepository;
    }

    @GetMapping
    public List<Knjiga> pregledajSveKnjige() {  //pregled knjiga
        return knjigaRepository.findAll();
    }
}
