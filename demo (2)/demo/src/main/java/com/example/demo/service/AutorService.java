package com.example.demo.service;

import com.example.demo.Entity.Autor;
import com.example.demo.Entity.Korisnik;
import com.example.demo.Repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.security.AuthProvider;
import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    private AutorRepository autorRepository;

    public Autor findOne(String username){
        Optional<Autor> foundAutor = autorRepository.findByUserName(username);
        if (foundAutor.isPresent())
            return  foundAutor.get();

        return null;
    }

    //public List<Autor> findAll(){return autorRepository.findAll();}

    public Autor save(Autor autor){
        return autorRepository.save(autor);
    }
}
