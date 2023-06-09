package com.example.demo.controller;

import com.example.demo.Entity.ZahtevZaAktivacijuAutora;
import com.example.demo.Repository.AutorRepository;
import com.example.demo.Repository.ZahtevZaAktivacijuAutoraRepository;
import com.example.demo.dto.ZahtevZaAktivacijuAutoraDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/zahtevi-za-aktivaciju-autora")
public class ZahtevZaAktivacijuAutoraController {

    private final ZahtevZaAktivacijuAutoraRepository zahtevRepository;

    public ZahtevZaAktivacijuAutoraController(ZahtevZaAktivacijuAutoraRepository zahtevZaAktivacijuAutoraRepository) {
        this.zahtevRepository = zahtevZaAktivacijuAutoraRepository;
    }

    @PostMapping("/kreiraj")
    public ResponseEntity<String> podnesiZahtevZaAktivacijuAutora(@RequestBody ZahtevZaAktivacijuAutoraDTO zahtevDTO) { //umesto ? moze String

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


    @GetMapping("/{id}/pronadji")
    public ResponseEntity<ZahtevZaAktivacijuAutoraDTO> pronadjiZahtevZaAktivaciju(@PathVariable("id") Long id) {
        Optional<ZahtevZaAktivacijuAutora> zahtevOptional = zahtevRepository.findById(id);

        if (zahtevOptional.isPresent()) {
            ZahtevZaAktivacijuAutora zahtev = zahtevOptional.get();

            ZahtevZaAktivacijuAutoraDTO zahtevDTO = new ZahtevZaAktivacijuAutoraDTO(zahtev.getEmail(),zahtev.getBrojTelefona(),zahtev.getDodatnaPoruka());
            zahtevDTO.setEmail(zahtev.getEmail());

            return ResponseEntity.ok(zahtevDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
