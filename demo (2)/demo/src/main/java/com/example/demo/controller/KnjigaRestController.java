package com.example.demo.controller;

import com.example.demo.Entity.Knjiga;
import com.example.demo.Repository.KnjigaRepository;
import com.example.demo.service.KnjigaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController

public class KnjigaRestController {
    private KnjigaService knjigaService;
    private final KnjigaRepository knjigaRepository; //final je da se ne moze menjati

    public KnjigaRestController(KnjigaRepository knjigaRepository) {
        this.knjigaRepository = knjigaRepository;
    }

    @GetMapping("/knjige")
    public List<Knjiga> pregledajSveKnjige() {  //pregled knjiga
        return knjigaRepository.findAll();
    }
}
