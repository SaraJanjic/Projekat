package com.example.demo.service;

import com.example.demo.Entity.Knjiga;
import com.example.demo.Entity.Korisnik;
import com.example.demo.Repository.KnjigaRepository;

import java.util.Optional;

public class KnjigaService {
    private KnjigaRepository knjigaRepository;

    public Knjiga findOne(String naziv){
        Optional<Knjiga> foundKnjiga = knjigaRepository.findByNaslov(naziv);
        if (foundKnjiga.isPresent())
            return foundKnjiga.get();

        return null;
    }
}
