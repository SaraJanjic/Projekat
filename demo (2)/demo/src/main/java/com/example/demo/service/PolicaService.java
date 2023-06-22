package com.example.demo.service;

import com.example.demo.Entity.Knjiga;
import com.example.demo.Entity.Korisnik;
import com.example.demo.Entity.Polica;
import com.example.demo.Entity.Uloga;
import com.example.demo.Repository.KnjigaRepository;
import com.example.demo.Repository.PolicaRepository;
import com.example.demo.dto.PolicaDto;
import com.example.demo.dto.RegistracijaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PolicaService {
    @Autowired
    private PolicaRepository policaRepository;
   // @Autowired
   // private KnjigaRepository knjigaRepository;



    /*public Polica findOne(Long id){
        Optional<Polica> foundPolica = policaRepository.findById(id);
        if (foundPolica.isPresent())
            return foundPolica.get();

        return null;
    }*/

    public List<Polica> findAll(){
        return policaRepository.findAll();
    }

    public Polica save(Polica polica){ return policaRepository.save(polica);
    }

    public Polica kreirajPolicu(String naziv) { //radi
        Polica polica = new Polica();
        polica.setNaziv(naziv);
        polica.setOznakaPolice(true);
        save(polica);
        return polica;
    }


    public boolean brisiPolicu(String naziv) { //radi
        Optional<Polica> policaO = policaRepository.findByNaziv(naziv);
            if(policaO.isPresent()){
                Polica polica = policaO.get();
                policaRepository.delete(polica);
                return true;
             }else{
                //throw new PolicaNotFoundException("POlica nije nadjena." + naziv);
                return false;
            }
        }

    public Polica napraviPolicu(String name){ //radi
        Optional<Polica> postojecaPolica = policaRepository.findByNaziv(name);
        if(postojecaPolica.isPresent()){
            return  null;
        }
        Polica polica = new Polica();
        polica.setNaziv(name);
        polica.setOznakaPolice(false);
        return policaRepository.save(polica);
    }

    public Polica findById(Long policeId) {
        return policaRepository.findById(policeId).get();
    }

/*
    public boolean dodajKnjiguNaPolicu(String nazivPolice, String naslovKnjige){ //ne radi
        Knjiga knjiga = knjigaRepository.findByNaslov(naslovKnjige);
            if(knjiga==null){
                return false;
            }
            Polica polica=policaRepository.findByNaziv(nazivPolice).get();
            if(polica==null){
                return false;
            }

        if(polica.getOznakaPolice() == true && polica.getStavkaPolice().getKnjiga().getNaslov().equals(naslovKnjige)){
            return false;
        }

    polica.getStavkaPolice().setKnjiga(knjiga);
    policaRepository.save(polica);
    return true;
    }
*/

}
