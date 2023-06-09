package com.example.demo.service;

import com.example.demo.Entity.Korisnik;
import com.example.demo.Entity.Zanr;
import com.example.demo.Repository.ZanrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ZanrService {

    @Autowired
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
