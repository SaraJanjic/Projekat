package com.example.demo.controller;

import com.example.demo.Entity.Knjiga;
import com.example.demo.Entity.Zahtev;
import com.example.demo.Entity.Zanr;
import com.example.demo.dto.DodavanjeKnjigeNaPolicuDto;
import com.example.demo.dto.KnjigaDto;
import com.example.demo.service.KnjigaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class KnjigaRestController {
    private KnjigaService knjigaService;

   @GetMapping("/api/search/{zanr}") //trazi knjigu po zanru ali ne radi
    public ResponseEntity<List<KnjigaDto>> traziKnjige(@PathVariable(name = "zanr")Zanr zanr, HttpSession session){
        List<Knjiga> knjige = knjigaService.nadjiSveKnjige();

        List<KnjigaDto> knjigePoZanru = new ArrayList<>();

        for(Knjiga k : knjige){
            if(k.getZanr() == zanr){
                KnjigaDto dto = new KnjigaDto(k);
                knjigePoZanru.add(dto);
            }
       }
        return  ResponseEntity.ok(knjigePoZanru);
    }


    @GetMapping("/api/knjige") //metoda koja treba da vraca sve knjige koje su u bazi ali ne radi
    public ResponseEntity<List<KnjigaDto>> traziKnjige(){
        List<Knjiga> knjige = knjigaService.nadjiSveKnjige();

        List<KnjigaDto> dtos = new ArrayList<>();
        for(Knjiga k : knjige){
                KnjigaDto dto = new KnjigaDto(k);
                dtos.add(dto);
        }
        return  ResponseEntity.ok(dtos);
    }


  /*  @PostMapping("/knjige/dodaj-na-policu")
    public ResponseEntity<String> dodajKnjiguNaPolicu(@RequestBody DodavanjeKnjigeNaPolicuDto dto){
        String nazivKnjige = dto.getNazivKnjige();
        String nazivPolice = dto.getNazivPolice();


        return  ResponseEntity.ok("Knjiga dodata na policu!");

    }*/


}
