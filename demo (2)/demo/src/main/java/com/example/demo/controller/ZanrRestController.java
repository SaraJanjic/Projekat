package com.example.demo.controller;

import com.example.demo.Entity.Knjiga;
import com.example.demo.Entity.Zanr;
import com.example.demo.dto.KnjigaDto;
import com.example.demo.dto.ZanrDto;
import com.example.demo.service.ZahtevService;
import com.example.demo.service.ZanrService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

public class ZanrRestController {
    private ZanrService zanrService;

    @GetMapping("/api/zanrovi") //metoda koja treba da vraca sve zanrove koje su u bazi ali ne radi
    public ResponseEntity<List<ZanrDto>> vratiZanr(){
        List<Zanr> zanrs = zanrService.findAll();

        List<ZanrDto> dtos = new ArrayList<>();
        for(Zanr z : zanrs){
            ZanrDto dto = new ZanrDto(z);
            dtos.add(dto);
        }
        return  ResponseEntity.ok(dtos);
    }
}
