package com.example.demo.service;

import com.example.demo.Entity.Korisnik;
import com.example.demo.Entity.Polica;
import com.example.demo.Repository.PolicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicaService {
    @Autowired
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

    public Polica kreirajPolicu(String naziv) {
        Polica polica = new Polica();
        polica.setNaziv(naziv);
        polica.setOznakaPolice(true);
        save(polica);
        return polica;
    }
}
