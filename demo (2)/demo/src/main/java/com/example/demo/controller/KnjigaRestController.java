package com.example.demo.controller;

import com.example.demo.Entity.Knjiga;
import com.example.demo.dto.DodavanjeKnjigeNaPolicuDto;
import com.example.demo.service.KnjigaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public class KnjigaRestController {
    private KnjigaService knjigaService;

   /* @PostMapping("/book/search")
    public Optional<Knjiga> searchKnjige(@RequestParam String q, @RequestParam(required = false, defaultValue = "books") String search_type) {
        return knjigaService.searchKnjige(q);
    }*/


  /*  @PostMapping("/knjige/dodaj-na-policu")
    public ResponseEntity<String> dodajKnjiguNaPolicu(@RequestBody DodavanjeKnjigeNaPolicuDto dto){
        String nazivKnjige = dto.getNazivKnjige();
        String nazivPolice = dto.getNazivPolice();


        return  ResponseEntity.ok("Knjiga dodata na policu!");

    }*/


}
