package com.example.demo.controller;

import com.example.demo.Entity.Polica;
import com.example.demo.Repository.PolicaRepository;
import com.example.demo.service.PolicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/police")

public class PolicaRestController {
    private PolicaService policaService;

    @Autowired
    private PolicaRepository policaRepository;

    public PolicaRestController() {
    }

    @PostMapping
    public Polica addShelf(@RequestBody Polica polica) {
        return policaRepository.save(polica);
    }

    @DeleteMapping("/{policaId}")
    public void deleteShelf(@PathVariable Long policaId) {
        policaRepository.deleteById(policaId);
    }

}
