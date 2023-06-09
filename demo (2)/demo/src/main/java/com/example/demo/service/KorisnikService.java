package com.example.demo.service;

import com.example.demo.Entity.Korisnik;
import com.example.demo.Entity.Polica;
import com.example.demo.Entity.Uloga;
import com.example.demo.Repository.KorisnikRepository;
import com.example.demo.dto.RegistracijaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;
    @Autowired
    private PolicaService policaService;

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

    public ResponseEntity register(RegistracijaDto dto) {
        if (korisnikRepository.findByUserName(dto.getUserName()).isPresent())
            return new ResponseEntity("Vec postoji taj username.", HttpStatus.BAD_REQUEST);

        if (korisnikRepository.findByEmail(dto.getUserName()).isPresent())
            return new ResponseEntity("Vec postoji taj email.", HttpStatus.BAD_REQUEST);

        if (dto.getIme() == null || dto.getPrezime() == null || dto.getEmail() == null || dto.getUserName() == null || dto.getLozinka() == null)
            return new ResponseEntity("Fali vam neko polje.", HttpStatus.BAD_REQUEST);

        Korisnik korisnik = new Korisnik();
        korisnik.setIme(dto.getIme());
        korisnik.setPrezime(dto.getPrezime());
        korisnik.setUserName(dto.getUserName());
        korisnik.setEmail(dto.getEmail());
        korisnik.setLozinka(dto.getLozinka());
        korisnik.setUloga(Uloga.CITALAC);

        Set<Polica> police = new HashSet<>();
        police.add(policaService.kreirajPolicu("Read"));
        police.add(policaService.kreirajPolicu("Want to Read"));
        police.add(policaService.kreirajPolicu("Currently Reading"));

        korisnik.setKorisnickePolice(police);

        korisnikRepository.save(korisnik);
        return new ResponseEntity("Uspesna registracija.", HttpStatus.OK);
    }

    public Korisnik login(String email, String password) {
        Korisnik korisnik = korisnikRepository.getByEmail(email);
        if(korisnik == null || !korisnik.getLozinka().equals(password))
            return null;
        return  korisnik;
    }

    public boolean dodajPolicuKorisniku(Long id, String imePolice){
        List<Korisnik> korisnici = korisnikRepository.findAll();
        for(Korisnik user : korisnici){
            if(user.getId() == id){
                Set<Polica> police = user.getKorisnickePolice();
                police.add(policaService.napraviPolicu(imePolice));
                user.setKorisnickePolice(police);
                korisnikRepository.save(user);
            }
        }
        return true;
    }

    public Polica izbrisiPolicu(Long id, String naziv){
        List<Korisnik> korisnici = korisnikRepository.findAll();
        for(Korisnik user : korisnici){
            if(user.getId() == id){
                Set<Polica> police = user.getKorisnickePolice();
                for(Polica polica : police){
                    if(polica.getNaziv().equals(naziv) && polica.getOznakaPolice()==false){
                        user.getKorisnickePolice().remove(polica);
                        return  polica;
                    }
                }
            }
        }
        return  null;
    }

   public Korisnik findByEmail(String email) {
        return korisnikRepository.findByEmail(email).get();
    }


    public Korisnik findById(Long id) {
        return  korisnikRepository.findById(id).get();
    }
}
