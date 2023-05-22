package com.example.demo.service;

import com.example.demo.Entity.Knjiga;
import com.example.demo.Entity.Korisnik;
import com.example.demo.Entity.StavkaPolice;
import com.example.demo.Repository.StavkaPoliceRepository;

import java.util.List;
import java.util.Optional;

public class StavkaPoliceService {
    private StavkaPoliceRepository stavkaPoliceRepository;
    public StavkaPolice findOne(Knjiga knjiga){
        Optional<StavkaPolice> foundStavkaPolice = stavkaPoliceRepository.findByKnjiga(knjiga);
        if (foundStavkaPolice.isPresent())
            return foundStavkaPolice.get();

        return null;
    }
    public List<StavkaPolice> findAll(){ return stavkaPoliceRepository.findAll();
    }
    public StavkaPolice save(StavkaPolice stavkaPolice){return stavkaPoliceRepository.save(stavkaPolice);
    }
}
