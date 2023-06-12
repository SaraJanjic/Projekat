package com.example.demo.service;

import com.example.demo.Entity.*;
import com.example.demo.Repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AutorService {
    @Autowired
    private PolicaService policaService;

    @Autowired
    private AutorRepository autorRepository;

    public Autor findOne(String username){
        Optional<Autor> foundAutor = autorRepository.findByUserName(username);
        if (foundAutor.isPresent())
            return  foundAutor.get();

        return null;
    }

    //public List<Autor> findAll(){return autorRepository.findAll();}

    public Autor save(Autor autor){

        autor.setAktivnost(true);
        autor.setUloga(Uloga.valueOf("AUTOR"));

        Set<Polica> police = new HashSet<>();
        police.add(policaService.kreirajPolicu("Read"));
        police.add(policaService.kreirajPolicu("Want to Read"));
        police.add(policaService.kreirajPolicu("Currently Reading"));

        autor.setKorisnickePolice(police);


        return autorRepository.save(autor);
    }

    public List<Korisnik> findAll() {
        return autorRepository.findAll();
    }

}
