package com.example.demo.controller;

import com.example.demo.Entity.Autor;
import com.example.demo.Entity.Korisnik;
import com.example.demo.Entity.ZahtevZaAktivacijuAutora;
import com.example.demo.Repository.AutorRepository;
import com.example.demo.dto.ZahtevZaAktivacijuAutoraDTO;
import com.example.demo.service.AutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
@RestController
public class AutorRestController {
    private final AutorRepository autorRepository;
    private AutorService autorService;

    public AutorRestController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping("/{autorId}/zahtev-za-aktivaciju")
    public ResponseEntity<?> podnesiZahtevZaAktivacijuNaloga(@PathVariable Long autorId,
                                                             @RequestBody ZahtevZaAktivacijuAutora zahtev) {


        Optional<Korisnik> optionalAutor = autorRepository.findById(autorId); //ne da mi Autor samo Korisnik da stavim u<>
        if (optionalAutor.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Autor autor = (Autor) optionalAutor.get();

        ZahtevZaAktivacijuAutoraDTO zahtevDTO = new ZahtevZaAktivacijuAutoraDTO(zahtev.getEmail(), zahtev.getBrojTelefona(), zahtev.getDodatnaPoruka());
        //ove metode su static, tako je jedino htelo, ne znam oce raditi
        zahtevDTO.setEmail(zahtev.getEmail());
        zahtevDTO.setDodatnaPoruka(zahtev.getDodatnaPoruka());
        zahtevDTO.setBrojTelefona(zahtev.getBrojTelefona());

       autor.setEmail(zahtevDTO.getEmail()); //ovo zakomentarisi ako ne radi
       /* autor.setDodatnaPoruka(zahtevDTO.getDodatnaPoruka())
        autor.setBrojTelefona(zahtevDTO.getBrojTelefona());*/


        autorRepository.save(autor);

        return ResponseEntity.ok("Zahtjev za aktivaciju naloga autora je podnesen.");
    }

}
