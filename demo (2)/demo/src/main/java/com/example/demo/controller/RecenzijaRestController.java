package com.example.demo.controller;

import com.example.demo.Entity.Recenzija;
import com.example.demo.Repository.RecenzijaRepository;
import com.example.demo.service.RecenzijaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController

public class RecenzijaRestController {
    private RecenzijaService recenzijaService;
    private final RecenzijaRepository recenzijaRepository;

    public RecenzijaRestController(RecenzijaRepository recenzijaRepository) {
        this.recenzijaRepository = recenzijaRepository;
    }

    @GetMapping("/recenzije")
    public List<Recenzija> pregledajSveRecenzije() {
        return recenzijaRepository.findAll();
    }
}
