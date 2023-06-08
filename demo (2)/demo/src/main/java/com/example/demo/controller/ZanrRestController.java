package com.example.demo.controller;

import com.example.demo.Entity.Zanr;
import com.example.demo.Repository.ZanrRepository;
import com.example.demo.service.ZahtevService;
import com.example.demo.service.ZanrService;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ZanrRestController {
    private ZanrService zanrService;
    private final ZanrRepository zanrRepository;

    public ZanrRestController(ZanrRepository zanrRepository) {
        this.zanrRepository = zanrRepository;
    }

    @GetMapping
    public List<Zanr> pregledajSveZanrove() {
        return zanrRepository.findAll();
    }
}
