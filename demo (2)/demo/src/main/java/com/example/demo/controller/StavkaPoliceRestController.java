package com.example.demo.controller;

import com.example.demo.Entity.Recenzija;
import com.example.demo.Entity.StavkaPolice;
import com.example.demo.dto.RecenzijaDto;
import com.example.demo.service.StavkaPoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StavkaPoliceRestController {

    @Autowired
    private StavkaPoliceService stavkaPoliceService;


    @GetMapping("/api/stavke") //metoda koja treba da vraca sve recenzije koje su u bazi
    @CrossOrigin
    public ResponseEntity<List<StavkaPolice>> vratiStavke() {
        List<StavkaPolice> stavka = stavkaPoliceService.findAll();

        if(stavka == null){
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }

        return ResponseEntity.ok(stavka);
    }
}
