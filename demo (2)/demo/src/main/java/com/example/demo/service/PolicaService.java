package com.example.demo.service;

import com.example.demo.Entity.Korisnik;
import com.example.demo.Entity.Polica;
import com.example.demo.Repository.PolicaRepository;

import java.util.List;
import java.util.Optional;

public class PolicaService {
    private PolicaRepository policaRepository;

    public Polica findOne(Long id){
        Optional<Polica> foundPolica = policaRepository.findById(id);
        if (foundPolica.isPresent())
            return foundPolica.get();

        return null;
    }

    public List<Polica> findAll(){
        return policaRepository.findAll();
    }

    public Polica save(Polica polica){ return policaRepository.save(polica);
    }
}
