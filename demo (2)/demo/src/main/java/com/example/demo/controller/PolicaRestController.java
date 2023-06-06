package com.example.demo.controller;

import com.example.demo.Entity.Polica;
import com.example.demo.Repository.PolicaRepository;
import com.example.demo.dto.PolicaDto;
import com.example.demo.dto.RegistracijaDto;
import com.example.demo.service.PolicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/police")
public class PolicaRestController {

    @Autowired
    private PolicaService policaService;

    @Autowired
    private PolicaRepository policaRepository;

    public PolicaRestController() {
    }

    //@PostMapping("/police")
    //public Polica addShelf(@RequestBody PolicaDto dto) {
        //return policaRepository.save(dto);
    //}

    @DeleteMapping("/police/{naziv}")
    public String deletePolica(@PathVariable String naziv) {
        return policaService.deletePolica(naziv);
    }
/*
    @PostMapping("/police/{naziv}")
    public ResponseEntity napraviPolicu(@RequestBody PolicaDto dto) {
        return policaService.napraviPolicu(dto);
    }
*/

    /*
    @PostMapping("/police")
    public PolicaDto napraviPolicu(@RequestBody PolicaDto policaDto){
        Polica napravljenaPolica = policaService.napraviPolicu(policaDto);
        return new PolicaDto(napravljenaPolica.getNaziv(), napravljenaPolica.getOznakaPolice());
    }
    */
    @PostMapping("/police")
    public ResponseEntity<String> napraviPolicu(@RequestBody String name) {
        Polica napravljenaPolica = policaService.napraviPolicu(name);
        if(napravljenaPolica == null){
            return  ResponseEntity.status(HttpStatus.CONFLICT).body("Polica vec postoji!");
        }else{
            return  ResponseEntity.status(HttpStatus.CREATED).body("Polica napravljena!");
        }
    }

@PostMapping("/{nazivPolice}/knjige")
    public ResponseEntity<String> dodajKnjiguNaPolicu(@PathVariable String nazivPolice, @RequestParam String nazivKnjige){
        boolean uspesno= policaService.dodajKnjiguNaPolicu(nazivKnjige,nazivPolice);
        if(uspesno){
            return ResponseEntity.ok("Knjiga dodata na policu");
        }else{
            return ResponseEntity.badRequest().body("Neuspesno dodavanje");
        }
}


}
