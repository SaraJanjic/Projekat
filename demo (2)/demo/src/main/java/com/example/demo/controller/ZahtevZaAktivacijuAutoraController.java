package com.example.demo.controller;

import com.example.demo.Entity.Autor;
import com.example.demo.Entity.Korisnik;
import com.example.demo.Entity.Status;
import com.example.demo.Entity.ZahtevZaAktivacijuAutora;
import com.example.demo.Repository.AutorRepository;
import com.example.demo.Repository.ZahtevZaAktivacijuAutoraRepository;
import com.example.demo.dto.ZahtevZaAktivacijuAutoraDTO;
import com.example.demo.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
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

    /*@PostMapping("/api/sacuvaj-autora")
    public String saveAutor(@RequestBody Autor autor) {
        this.autorService.save(autor);
        return "Sacuvan autor u bazi!";
    }*/

    @PostMapping("/api/napravi-autora/{zahtevId}")
    public String napraviAutora(@PathVariable (name="zahtevId") Long zahtevId, @RequestBody Autor autor) {
        Optional<ZahtevZaAktivacijuAutora> zahtevOptional = zahtevRepository.findById(zahtevId);
        if (zahtevOptional.isPresent()) {
            ZahtevZaAktivacijuAutora zahtev = zahtevOptional.get();
            if (zahtev.getStatus().equals(Status.ODOBREN)) {
                this.autorService.save(autor);
                return "Sacuvan autor u bazi!";
            }
        }
        return "Autor nije sacuvan. Zahtev nije odobren.";

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

}
