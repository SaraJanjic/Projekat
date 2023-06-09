package com.example.demo.service;

import com.example.demo.Entity.Knjiga;
import com.example.demo.Repository.KnjigaRepository;
import com.example.demo.dto.KnjigaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KnjigaService {

    @Autowired
    private KnjigaRepository knjigaRepository;

    public List<Knjiga> nadjiSveKnjige() {
        return knjigaRepository.findAll();
    }

    public Knjiga nadjiKnjiguPoNaslovu(String naslov) {

        Knjiga knjiga = knjigaRepository.findByNaslov(naslov);

        if(knjiga != null){
            return knjiga;
        }

        List<Knjiga> knjige = knjigaRepository.findAll();

        for (Knjiga k : knjige) {
            if(k.getNaslov().equalsIgnoreCase(naslov)){
                return  k;
            }else if(k.getNaslov().contains(naslov)){
                return  k;
            }
        }
        return null;
    }

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
