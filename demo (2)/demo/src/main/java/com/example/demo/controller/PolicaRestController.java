package com.example.demo.controller;

import com.example.demo.Entity.Korisnik;
import com.example.demo.Entity.Polica;
import com.example.demo.Repository.PolicaRepository;
import com.example.demo.dto.PolicaDto;
import com.example.demo.dto.RegistracijaDto;
import com.example.demo.service.KorisnikService;
import com.example.demo.service.PolicaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/police")
public class PolicaRestController {

    @Autowired
    private PolicaService policaService;
    @Autowired

    private KorisnikService korisnikService;

    private  PolicaRepository policaRepository;

    public PolicaRestController(PolicaRepository policaRepository) {
        this.policaRepository = policaRepository;
    }

    @GetMapping
    public List<Polica> pregledajSvePolice() {
        return policaRepository.findAll();
    }



    public PolicaRestController() {
    }


    @PostMapping("/api/napraviPolicu")
    public ResponseEntity<String> napraviPolicu(@RequestBody PolicaDto policaDto, HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        Long userId = null;

        if(loggedKorisnik == null){
            return new ResponseEntity<>("Niste ulogovani.", HttpStatus.UNAUTHORIZED);
        }else{
            userId = loggedKorisnik.getId();
        }

        boolean jeliNapravljena = korisnikService.dodajPolicuKorisniku(userId, policaDto.getNaziv());

        if(jeliNapravljena){
            return new ResponseEntity<>("polica dodata korisniku", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("polica nije dodata korisniku", HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/api/izbrisiPolicu")
    public ResponseEntity<String> izbrisiPolicu(@RequestBody PolicaDto policaDto, HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        Long userId = null;

        if(loggedKorisnik == null){
            return new ResponseEntity<>("Niste ulogovani.", HttpStatus.UNAUTHORIZED);
        }else{
            userId = loggedKorisnik.getId();
        }

        Polica obrisanaPolica = korisnikService.izbrisiPolicu(userId, policaDto.getNaziv());

        if(obrisanaPolica == null){
            return new ResponseEntity<>("Polica ne postoji.", HttpStatus.BAD_REQUEST);
        }

        boolean obrisanaIzBaze = policaService.brisiPolicu(obrisanaPolica.getNaziv());

        if(obrisanaIzBaze){
            return new ResponseEntity<>("Polica je uklonjena iz baze.", HttpStatus.OK);
        }else{
            return  new ResponseEntity<>("Polica nije uklonjena iz baze.", HttpStatus.CONFLICT);
        }

    }
/*
@PostMapping("/dodajKnjiuNaPolicu/{nazivPolice}/{naslovKnjige}")
    public ResponseEntity<String> dodajKnjiguNaPolicu(@PathVariable(name = "nazivPolice") String nazivPolice, @PathVariable(name = "naslovKnjige") String naslovKnjige){
        boolean uspesno= policaService.dodajKnjiguNaPolicu(nazivPolice,naslovKnjige);
        if(uspesno){
            return ResponseEntity.ok("Knjiga dodata na policu");
        }else{
            return ResponseEntity.badRequest().body("Neuspesno dodavanje");
        }
}
*/

}
