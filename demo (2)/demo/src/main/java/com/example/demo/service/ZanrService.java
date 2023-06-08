package com.example.demo.service;

import com.example.demo.Entity.Korisnik;
import com.example.demo.Entity.Zanr;
import com.example.demo.Repository.ZanrRepository;

import java.util.List;
import java.util.Optional;

public class ZanrService {
    private ZanrRepository zanrRepository;
    public Zanr findOne(String nazivZanra){
        Optional<Zanr> foundZanr = zanrRepository.findByNazivZanra(nazivZanra);
        if (foundZanr.isPresent())
            return foundZanr.get();

        return null;
    }

    public List<Zanr> findAll(){
        return zanrRepository.findAll();
    }

    public Zanr save(Zanr zanr){
        return zanrRepository.save(zanr);
    }


}
