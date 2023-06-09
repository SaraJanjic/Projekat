package com.example.demo.controller;

import com.example.demo.Entity.Knjiga;
import com.example.demo.Entity.Zanr;
import com.example.demo.dto.KnjigaDto;
import com.example.demo.service.KnjigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class KnjigaRestController {

    @Autowired
    private KnjigaService knjigaService;

    @GetMapping("/api/traziKnjiguPoZanru/{zanrId}") //trazi knjigu po zanru
    public ResponseEntity<List<KnjigaDto>> traziKnjige(@PathVariable(name = "zanrId") Zanr zanr) {
        List<Knjiga> knjige = knjigaService.nadjiSveKnjige();

        List<KnjigaDto> knjigePoZanru = new ArrayList<>();

        for (Knjiga k : knjige) {
            if (k.getZanr() == zanr) {
                KnjigaDto dto = new KnjigaDto(k);
                knjigePoZanru.add(dto);
            }
        }
        return ResponseEntity.ok(knjigePoZanru);
    }


    @GetMapping("/api/knjige") //metoda koja treba da vraca sve knjige koje su u bazi
    public ResponseEntity<List<KnjigaDto>> traziKnjige() {
        List<Knjiga> knjige = knjigaService.nadjiSveKnjige();

        List<KnjigaDto> dtos = new ArrayList<>();
        for (Knjiga k : knjige) {
            KnjigaDto dto = new KnjigaDto(k);
            dtos.add(dto);
        }
        if(dtos.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
        return ResponseEntity.ok(dtos);
    }

    //pretraga knjiga po naslovu
    @GetMapping("/api/traziKnjiguPoNaslovu/{naslov}") //trazi knjigu po naslovu
    public ResponseEntity<KnjigaDto> traziKnjigePoNaslovu(@PathVariable(name = "naslov") String naslov){


        Knjiga k = knjigaService.nadjiKnjiguPoNaslovu(naslov);

        if(k == null){
            return  new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

        KnjigaDto dto = new KnjigaDto(k);

        return ResponseEntity.ok(dto);
    }


}


  /*  @PostMapping("/knjige/dodaj-na-policu")
    public ResponseEntity<String> dodajKnjiguNaPolicu(@RequestBody DodavanjeKnjigeNaPolicuDto dto){
        String nazivKnjige = dto.getNazivKnjige();
        String nazivPolice = dto.getNazivPolice();


        return  ResponseEntity.ok("Knjiga dodata na policu!");

    }*/

/*
import com.example.demo.Repository.KnjigaRepository;
import com.example.demo.service.KnjigaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController

public class KnjigaRestController {
    private KnjigaService knjigaService;
    private final KnjigaRepository knjigaRepository; //final je da se ne moze menjati

    public KnjigaRestController(KnjigaRepository knjigaRepository) {
        this.knjigaRepository = knjigaRepository;
    }

    @GetMapping("/knjige")
    public List<Knjiga> pregledajSveKnjige() {  //pregled knjiga
        return knjigaRepository.findAll();
    }

}
*/

