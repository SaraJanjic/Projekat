package com.example.demo.service;

import com.example.demo.Entity.Korisnik;
import com.example.demo.Entity.Zahtev;
import com.example.demo.Entity.Zanr;
import com.example.demo.Repository.ZahtevRepository;

import java.util.List;
import java.util.Optional;

public class ZahtevService {
    private ZahtevRepository zahtevRepository;
    public Zahtev findOne(Long id){
        Optional<Zahtev> foundZahtev = zahtevRepository.findById(id);
        if (foundZahtev.isPresent())
            return foundZahtev.get();

        return null;
    }

    public List<Zahtev> findAll(){
        return zahtevRepository.findAll();
    }

    public Zahtev save(Zahtev zahtev){
        return zahtevRepository.save(zahtev);
    }
}
