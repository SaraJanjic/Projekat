package com.example.demo.service;

import com.example.demo.Entity.Korisnik;
import com.example.demo.Entity.Recenzija;
import com.example.demo.Repository.RecenzijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RecenzijaService {

    @Autowired
    private RecenzijaRepository recenzijaRepository;
    public Recenzija findOne(int ocena){
        Optional<Recenzija> foundRecenzija = recenzijaRepository.findByOcena(ocena);
        if (foundRecenzija.isPresent())
            return foundRecenzija.get();

        return null;
    }
    public List<Recenzija> findAll(){
        return recenzijaRepository.findAll();
    }

    public Recenzija save(Recenzija recenzija){
        return recenzijaRepository.save(recenzija);
    }
}
