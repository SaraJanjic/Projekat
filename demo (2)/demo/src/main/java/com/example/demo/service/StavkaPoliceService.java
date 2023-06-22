package com.example.demo.service;

import com.example.demo.Entity.Knjiga;
import com.example.demo.Entity.Korisnik;
import com.example.demo.Entity.Polica;
import com.example.demo.Entity.StavkaPolice;
import com.example.demo.Repository.StavkaPoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StavkaPoliceService {

    @Autowired
    private StavkaPoliceRepository stavkaPoliceRepository;

    @Autowired
    private KnjigaService knjigaService;

   // @Autowired
    //PolicaService policaService;


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

    public StavkaPolice napraviStavku(String imeKnjige){
        List<Knjiga> knjige = knjigaService.nadjiSveKnjige();

        for(Knjiga k : knjige){
            if(k.getNaslov().equals(imeKnjige)){

                StavkaPolice stavka = new StavkaPolice();
                stavka.setKnjiga(k);
                stavka.setRecenzija(null);
                return stavkaPoliceRepository.save(stavka);
            }
        }

        return null;
    }
/*
    public void deleteStavkaPolice(Long id, Long id1) {
        Polica polica = policaService.findById(id);
        List<StavkaPolice> stavkaPolices = findAll();

        for(StavkaPolice s : stavkaPolices){
            if(s.getId() == id1){
                polica.getStavke().remove(s);
            }
        }
    }
*/


}
