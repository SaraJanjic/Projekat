package com.example.demo.controller;

import com.example.demo.Entity.Recenzija;
import com.example.demo.Entity.Zanr;
import com.example.demo.Repository.RecenzijaRepository;
import com.example.demo.dto.RecenzijaDto;
import com.example.demo.dto.ZanrDto;
import com.example.demo.service.RecenzijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController

public class RecenzijaRestController {

    @Autowired
    private RecenzijaService recenzijaService;

    //@GetMapping("/recenzije")
    //public List<Recenzija> pregledajSveRecenzije() {
    //    return recenzijaService.findAll();
    //}

    @GetMapping("/api/recenzije") //metoda koja treba da vraca sve recenzije koje su u bazi
    public ResponseEntity<List<RecenzijaDto>> vratiRecenzije() {
        List<Recenzija> recenzije = recenzijaService.findAll();

        List<RecenzijaDto> dtos = new ArrayList<>();
        for (Recenzija r : recenzije) {
            RecenzijaDto dto = new RecenzijaDto(r);
            dtos.add(dto);
        }

        if(dtos == null){
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }

        return ResponseEntity.ok(dtos);
    }




}
