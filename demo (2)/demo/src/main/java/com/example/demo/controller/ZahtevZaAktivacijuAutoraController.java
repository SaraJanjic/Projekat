package com.example.demo.controller;

import com.example.demo.Entity.*;
import com.example.demo.Repository.AutorRepository;
import com.example.demo.Repository.ZahtevZaAktivacijuAutoraRepository;
import com.example.demo.dto.ZahtevZaAktivacijuAutoraDTO;
import com.example.demo.service.AutorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

public class ZahtevZaAktivacijuAutoraController {

    @Autowired
    private final ZahtevZaAktivacijuAutoraRepository zahtevRepository;
    @Autowired
    private AutorService autorService;

    public ZahtevZaAktivacijuAutoraController(ZahtevZaAktivacijuAutoraRepository zahtevZaAktivacijuAutoraRepository) {
        this.zahtevRepository = zahtevZaAktivacijuAutoraRepository;
    }

    @PostMapping("/kreiraj-zahtev")
    public ResponseEntity<String> podnesiZahtevZaAktivacijuAutora(@RequestBody ZahtevZaAktivacijuAutoraDTO zahtevDTO) {

        if (zahtevDTO.getEmail() == null) {
            return ResponseEntity.badRequest().body("Niste popunili sva obavezna polja.");
        }

       // ZahtevZaAktivacijuAutoraDTO sacuvaniZahtev = (ZahtevZaAktivacijuAutoraDTO) zahtevRepository.save(zahtevDTO);
        ZahtevZaAktivacijuAutora zahtev = new ZahtevZaAktivacijuAutora();
        zahtev.setEmail(zahtevDTO.getEmail());
        zahtev.setBrojTelefona(zahtevDTO.getBrojTelefona());
        zahtev.setDodatnaPoruka(zahtevDTO.getDodatnaPoruka());

        ZahtevZaAktivacijuAutora sacuvaniZahtev = zahtevRepository.save(zahtev);


        return ResponseEntity.ok("Zahtev za aktivaciju autora je podnesen.");
    }


    @GetMapping("/{id}/pronadji-zahtev")
    public ResponseEntity<ZahtevZaAktivacijuAutoraDTO> pronadjiZahtevZaAktivaciju(@PathVariable("id") Long id) {
        Optional<ZahtevZaAktivacijuAutora> zahtevOptional = zahtevRepository.findById(id);

        if (zahtevOptional.isPresent()) {
            ZahtevZaAktivacijuAutora zahtev = zahtevOptional.get();

            ZahtevZaAktivacijuAutoraDTO zahtevDTO = new ZahtevZaAktivacijuAutoraDTO(zahtev.getStatus(),zahtev.getEmail(),zahtev.getBrojTelefona(),zahtev.getDodatnaPoruka());
            zahtevDTO.setEmail(zahtev.getEmail());

            return ResponseEntity.ok(zahtevDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/zahtevi-za-aktivaciju/{zahtevId}/prihvati")
    public ResponseEntity<String> prihvatiZahtev(@PathVariable(name ="zahtevId") Long zahtevId) {
        Optional<ZahtevZaAktivacijuAutora> zahtevOptional = zahtevRepository.findById(zahtevId);
        if (zahtevOptional.isPresent()) {
            ZahtevZaAktivacijuAutora zahtev = zahtevOptional.get();
            zahtev.setStatus(Status.valueOf("ODOBREN"));
            zahtevRepository.save(zahtev);
            return ResponseEntity.ok("Zahtev je uspešno prihvaćen.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/zahtevi-za-aktivaciju/{zahtevId}/odbij")
    public ResponseEntity<String> odbijZahtev(@PathVariable(name = "zahtevId") Long zahtevId) {
        Optional<ZahtevZaAktivacijuAutora> zahtevOptional = zahtevRepository.findById(zahtevId);
        if (zahtevOptional.isPresent()) {
            ZahtevZaAktivacijuAutora zahtev = zahtevOptional.get();
            zahtev.setStatus(Status.valueOf("ODBIJEN"));
            zahtevRepository.save(zahtev);
            return ResponseEntity.ok("Zahtev je uspešno odbijen.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/napravi-autora")
    public ResponseEntity<?> napraviAutora(@RequestBody ZahtevZaAktivacijuAutoraDTO zahtev, HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        Long korisnikId = null;

        if(loggedKorisnik == null){
            return new ResponseEntity<>("Nema sesije, ulogujte se.", HttpStatus.UNAUTHORIZED);
        }else{
            korisnikId = loggedKorisnik.getId();
        }
        if(loggedKorisnik.getUloga() == Uloga.ADMINISTRATOR){
            Autor a = new Autor();
            a.setAktivnost(true);
            a.setEmail(zahtev.getEmail());
            a.setUloga(Uloga.AUTOR);
            autorService.save(a);
            return ResponseEntity.ok("Autor je kreiran.");
        }
        return  ResponseEntity.badRequest().body("NIste administrator, nemate pristup.");

    }

}
