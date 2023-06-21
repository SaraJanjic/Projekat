package com.example.demo.service;

import com.example.demo.Entity.Knjiga;
import com.example.demo.Entity.Korisnik;
import com.example.demo.Entity.Polica;
import com.example.demo.Entity.StavkaPolice;
import com.example.demo.Repository.KnjigaRepository;
import com.example.demo.dto.KnjigaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class KnjigaService {

    @Autowired
    private KnjigaRepository knjigaRepository;

   // @Autowired
   // PolicaService policaService;

   // @Autowired
    //KorisnikService korisnikService;

   // @Autowired
    //StavkaPoliceService stavkaPoliceService;

    public List<Knjiga> nadjiSveKnjige() {
        return knjigaRepository.findAll();
    }

    public Knjiga nadjiKnjiguPoNaslovu(String naslov) {

        Knjiga knjiga = knjigaRepository.findByNaslov(naslov);

        if (knjiga != null) {
            return knjiga;
        }

        List<Knjiga> knjige = knjigaRepository.findAll();

        for (Knjiga k : knjige) {
            if (k.getNaslov().equalsIgnoreCase(naslov)) {
                return k;
            } else if (k.getNaslov().contains(naslov)) {
                return k;
            }
        }
        return null;
    }

    public void save(Knjiga knjiga) {
        knjigaRepository.save(knjiga);
    }

    //////po autoruuu
    public Knjiga nadjiKnjiguPoId(Long id) {
        return knjigaRepository.findById(id).get();
    }


    public Optional<Knjiga> findById(Long knjigaId) {
        return knjigaRepository.findById(knjigaId);
    }

    public void delete(Knjiga knjiga) {
        knjigaRepository.delete(knjiga);
    }

    /*
    public void deleteKnjiga(Long citalacAutorId, Long policeId, Long knjigaId) {

        Knjiga knjiga = knjigaRepository.getById(knjigaId) ;

        Korisnik korisnik = korisnikService.findById(citalacAutorId) ;

        Polica polica = policaService.findById(policeId);

        Set<Polica> konisnikovePolice = korisnik.getKorisnickePolice();

        if (polica.getOznakaPolice()) {

            if (polica.getNaziv().equals("Read")) {

                for (Polica p : konisnikovePolice) {

                    if (p.getStavke().stream().anyMatch(stavka -> stavka.getKnjiga().equals(knjiga))) {

                        for (StavkaPolice stavka : p.getStavke()) {

                            if (stavka.getKnjiga().equals(knjiga)) {

                                stavkaPoliceService.deleteStavkaPolice(p.getId(), stavka.getId());

                            } else {

                                for (Polica po : konisnikovePolice) {

                                    if (po.getStavke().stream().anyMatch(s -> stavka.getKnjiga().equals(knjiga)))

                                        for (StavkaPolice s : po.getStavke()) {

                                            if (stavka.getKnjiga().equals(knjiga)) {
                                                s.setKnjiga(null);

                                            }
                                        }
                                }
                            }
                        }
                    }
                    else{
                            for(StavkaPolice stavk : polica.getStavke()) {
                                if(stavk.getKnjiga().equals(knjiga)) {
                                    stavkaPoliceService.deleteStavkaPolice(policeId, stavk.getId());
                                }
                            }
                        }
                    }
                }
            }
        }

     */
}

