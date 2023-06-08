package com.example.demo.controller;



import com.example.demo.Entity.Korisnik;
import com.example.demo.Entity.Uloga;
import com.example.demo.Entity.Zanr;
import com.example.demo.Repository.ZanrRepository;
import com.example.demo.dto.KorisnikDto;
import com.example.demo.dto.ZanrDto;
import com.example.demo.service.ZahtevService;
import com.example.demo.service.ZanrService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
@RestController

public class ZanrRestController {
    private ZanrService zanrService;
    private final ZanrRepository zanrRepository;

    public ZanrRestController(ZanrRepository zanrRepository) {
        this.zanrRepository = zanrRepository;
    }

    @GetMapping("zanrovi")
    public List<Zanr> pregledajSveZanrove() {
        return zanrRepository.findAll();
    }

    @PostMapping("/api/dodavanjezanra")
    public ResponseEntity<String> dodajNoviZanr(@RequestBody ZanrDto zanrDto) {

        KorisnikDto korisnikdto = new KorisnikDto();

        if (!korisnikdto.getUloga().equals("ADMINISTRATOR")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Samo administratori mogu dodavati nove žanrove.");
        }

        ZanrDto zanrdto = new ZanrDto();
        zanrDto.setId(1L);
        zanrDto.setNazivZanra("Roman");

        Zanr zanr = new Zanr();
        zanr.setId(zanrDto.getId());
        zanr.setNazivZanra(zanrDto.getNazivZanra());

        zanrRepository.save(zanr);

        return ResponseEntity.ok("Novi žanr uspešno dodat.");
    }


}
