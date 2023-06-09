package com.example.demo.controller;

import com.example.demo.Entity.Knjiga;
import com.example.demo.Entity.Korisnik;
import com.example.demo.Entity.Zanr;
import com.example.demo.dto.KnjigaDto;
import com.example.demo.dto.KorisnikDto;
import com.example.demo.dto.ZanrDto;
import com.example.demo.service.KnjigaService;
import com.example.demo.service.KorisnikService;
import com.example.demo.service.ZahtevService;
import com.example.demo.service.ZanrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ZanrRestController {

    @Autowired
    private ZanrService zanrService;

    @Autowired
    private KorisnikService korisnikService;


    @GetMapping("/api/zanrovi") //metoda koja treba da vraca sve zanrove koje su u bazi
    public ResponseEntity<List<ZanrDto>> vratiZanr() {
        List<Zanr> zanrs = zanrService.findAll();

        List<ZanrDto> dtos = new ArrayList<>();
        for (Zanr z : zanrs) {
            ZanrDto dto = new ZanrDto(z);
            dtos.add(dto);
        }

        if(dtos == null){
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }

        return ResponseEntity.ok(dtos);
    }

    @PostMapping("/api/dodavanjezanra/{userId}") //ne radi skroz dobro
    public ResponseEntity<String> dodajNoviZanr(@PathVariable(name = "userId") Long id, @RequestBody ZanrDto zanrDto){

       Korisnik k = korisnikService.findById(id);

        if (k.getUloga().equals("ADMINISTRATOR")) {
            Zanr zanr = new Zanr();
            zanr.setId(zanrDto.getId());
            zanr.setNazivZanra(zanrDto.getNazivZanra());

            zanrService.save(zanr);

            return ResponseEntity.ok("Novi žanr uspešno dodat.");

       }else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Samo administratori mogu dodavati nove žanrove.");
        }

        /*
        ZanrDto zanrdto = new ZanrDto();
        zanrDto.setId(1L);
        zanrDto.setNazivZanra("Roman");
        */

    }


/*
    @GetMapping("/zanrovi")
    public List<Zanr> pregledajSveZanrove() {
        return zanrService.findAll();
    }
*/

}

/*
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
*/

