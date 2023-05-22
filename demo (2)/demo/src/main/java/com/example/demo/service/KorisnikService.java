package com.example.demo.service;

import com.example.demo.Entity.Korisnik;
import com.example.demo.Repository.KorisnikRepository;

import java.util.List;
import java.util.Optional;

public class KorisnikService {
    private KorisnikRepository korisnikRepository;

    public Korisnik findOne(Long id){
        Optional<Korisnik> foundKorisnik = korisnikRepository.findById(id);
        if (foundKorisnik.isPresent())
            return foundKorisnik.get();

        return null;
    }

    public List<Korisnik> findAll(){
        return korisnikRepository.findAll();
    }

    public Korisnik save(Korisnik korisnik){
        return korisnikRepository.save(korisnik);
    }

    public Korisnik login(String email, String password) {
        Korisnik korisnik = korisnikRepository.getByEmail(email);
        if(korisnik == null || !korisnik.getLozinka().equals(password))
            return null;
        return  korisnik;
    }
}
