package com.example.demo.service;

import com.example.demo.Entity.Knjiga;
import com.example.demo.Repository.KnjigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KnjigaService {

    @Autowired
    private static KnjigaRepository knjigaRepository;

    /*public static Knjiga findOne(String naziv){
        Optional<Knjiga> foundKnjiga = knjigaRepository.findByNaslov(naziv);
        if (foundKnjiga.isPresent())
            return foundKnjiga.get();

        return null;
    }

    public Optional<Knjiga> searchKnjige(String q){
        return knjigaRepository.findByNaslov(q);
    }*/

}
