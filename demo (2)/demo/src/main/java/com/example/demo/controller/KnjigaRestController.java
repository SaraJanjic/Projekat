package com.example.demo.controller;

import com.example.demo.Entity.*;
import com.example.demo.dto.DodavanjeKnjigeNaPolicuDto;
import com.example.demo.dto.KnjigaDto;
import com.example.demo.dto.KorisnikDto;
import com.example.demo.service.AutorService;
import com.example.demo.service.KnjigaService;
import com.example.demo.service.KorisnikService;
import com.example.demo.service.StavkaPoliceService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class KnjigaRestController {

    @Autowired
    private KnjigaService knjigaService;

    @Autowired
    private AutorService autorService;

    @Autowired
    KorisnikService korisnikService;
    @Autowired
    StavkaPoliceService stavkaPoliceService;

    @GetMapping("/api/traziKnjiguPoId/{id}") //trazi knjigu po id-u
    @CrossOrigin
    public ResponseEntity<List<KnjigaDto>> traziKnjige(@PathVariable(name = "id") Long id) {
        List<Knjiga> knjige = knjigaService.nadjiSveKnjige();

        List<KnjigaDto> knjigePoId = new ArrayList<>();

        for (Knjiga k : knjige) {
            if (k.getId() == id) {
                KnjigaDto dto = new KnjigaDto(k);
                knjigePoId.add(dto);
            }
        }
        return ResponseEntity.ok(knjigePoId);
    }


    @GetMapping("/api/traziKnjiguPoAutoru/{autor}") //trazi knjigu po naslovu, NE RADI
    public ResponseEntity<List<KnjigaDto>> traziKnjigePoAutoru(@PathVariable(name = "autor") String imeAutora) {

        List<Korisnik> autori = autorService.findAll();
        List<KnjigaDto> knjige = new ArrayList<>();
        Knjiga k = new Knjiga();
        Long id;

        for (Korisnik a : autori) {
            if (a.getUloga().equals("AUTOR")) {
                if (a.getIme().equals(imeAutora)) {
                    id = a.getId();
                    k = knjigaService.nadjiKnjiguPoId(id);
                    KnjigaDto dto = new KnjigaDto(k);
                    knjige.add(dto);
                }
            }
        }

        return ResponseEntity.ok(knjige);
    }


    @GetMapping("/api/knjige") //metoda kojavraca sve knjige koje su u bazi , RADI
    @CrossOrigin
    public ResponseEntity<List<KnjigaDto>> traziKnjige() {
        List<Knjiga> knjige = knjigaService.nadjiSveKnjige();

        List<KnjigaDto> dtos = new ArrayList<>();
        for (Knjiga k : knjige) {
            KnjigaDto dto = new KnjigaDto(k);
            dtos.add(dto);
        }
        if (dtos.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
        return ResponseEntity.ok(dtos);
    }

    //pretraga knjiga po naslovu
    @GetMapping("/api/traziKnjiguPoNaslovu/{naslov}") //trazi knjigu po naslovu, RADI
    @CrossOrigin
    public ResponseEntity<KnjigaDto> traziKnjigePoNaslovu(@PathVariable(name = "naslov") String naslov) {

        Knjiga k = knjigaService.nadjiKnjiguPoNaslovu(naslov);

        if (k == null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

        KnjigaDto dto = new KnjigaDto(k);

        return ResponseEntity.ok(dto);
    }


    @PostMapping("/{id}/knjige/dodaj-na-policu")
    public ResponseEntity<String> dodajKnjiguNaPolicu(@PathVariable(name = "id") Long id,

                                                      @RequestParam String naslov,

                                                      @RequestParam String naziv,

                                                      @RequestParam int ocena,

                                                      @RequestParam(required = false) String tekst,

                                                      @RequestParam(required = false) LocalDate datumRecenzije) {
        //HttpSession session) {
/*
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        Long userId = null;

        if(loggedKorisnik == null){
            return new ResponseEntity<>("Niste ulogovani.", HttpStatus.UNAUTHORIZED);
        }else{
            userId = loggedKorisnik.getId();
        }
*/
        boolean jelDodata = korisnikService.dodajKnjiguKorisnikuNaPolicu(id, naslov, naziv, ocena, tekst, datumRecenzije);

        if (jelDodata) {
            return ResponseEntity.ok("Knjiga je uspešno dodata korisniku na policu.");
        } else {
            return ResponseEntity.badRequest().body("Dodavanje knjige korisniku na policu nije uspelo.");
        }
    }


    @PostMapping("dodavanje-knjige-u-bazu")
    public ResponseEntity<?> dodajKnjigu(@RequestBody KnjigaDto knjigaDto, HttpSession session) {

        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");

        if (loggedKorisnik == null) {
            return ResponseEntity.ok("Niste ulogovani.");
        }

        if (loggedKorisnik.getUloga().equals(Uloga.ADMINISTRATOR) || loggedKorisnik.getUloga().equals(Uloga.AUTOR)) {
            Knjiga knjiga = new Knjiga();
            knjiga.setNaslov(knjigaDto.getNaslov());
            knjiga.setZanr(knjigaDto.getZanr());
            knjiga.setOpis(knjigaDto.getOpis());
            knjiga.setNaslovnaSlika(knjigaDto.getNaslovnaSlika());

            knjigaService.save(knjiga);

            Set<Polica> policas = loggedKorisnik.getKorisnickePolice();
            for(Polica p : policas){
                Set<StavkaPolice> stavke = p.getStavke();
                for(StavkaPolice s : stavke){
                    s.setKnjiga(knjiga);
                }
            }

            return ResponseEntity.ok("Knjiga je dodata u bazu!");
        } else {
            return ResponseEntity.ok("Samo administrator i autor mogu dodavati knjige u bazu!");
        }
    }


    // Metoda za ažuriranje knjige
    @PutMapping("/azuriranje-knjige/{knjigaId}")
    public ResponseEntity<?> azurirajKnjigu(@PathVariable Long knjigaId, @RequestBody KnjigaDto knjigaDto, HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");

        if (loggedKorisnik == null) {
            return ResponseEntity.ok("Niste ulogovani.");
        }

        if (loggedKorisnik.getUloga().equals(Uloga.ADMINISTRATOR) || loggedKorisnik.getUloga().equals(Uloga.AUTOR)) {
            Optional<Knjiga> knjigaOptional = knjigaService.findById(knjigaId);
            if (knjigaOptional.isPresent()) {
                Knjiga knjiga = knjigaOptional.get();

                knjiga.setNaslov(knjigaDto.getNaslov());
                knjiga.setZanr(knjigaDto.getZanr());
                knjiga.setOpis(knjigaDto.getOpis());
                knjiga.setNaslovnaSlika(knjigaDto.getNaslovnaSlika());

                knjigaService.save(knjiga);

                return ResponseEntity.ok("Knjiga je azurirana!");
            } else {
                return ResponseEntity.ok("Knjiga nije u bazi!");
            }
        } else {
            return ResponseEntity.ok("Samo administrator i autor mogu azurirati knjige!");
        }
    }



    @DeleteMapping("/brisanje-knjige-iz-baze/{knjigaId}")
    public ResponseEntity<?> obrisiKnjigu(@PathVariable(name = "knjigaId") Long knjigaId, HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");

        if (loggedKorisnik == null) {
            return ResponseEntity.ok("Niste ulogovani.");
        }

        if (loggedKorisnik.getUloga().equals(Uloga.ADMINISTRATOR)) {
            Optional<Knjiga> knjigaOptional = knjigaService.findById(knjigaId);
            if (knjigaOptional.isPresent()) {
                Knjiga knjiga = knjigaOptional.get();
                List<StavkaPolice> stavke = stavkaPoliceService.findAll();
                for (StavkaPolice s : stavke) {
                    if (s.getKnjiga().getId() == knjiga.getId()) {
                        if (s.getRecenzija() == null) {
                            knjigaService.delete(knjiga);
                            return new ResponseEntity("Knjiga obrisana!", HttpStatus.OK);
                        } else {
                            return new ResponseEntity("Knjiga ima recenziju, ne moze se obrisati!", HttpStatus.CONFLICT);
                        }

                    }
                    //knjigaService.delete(knjiga);
                    //return new ResponseEntity("Knjiga obrisana!", HttpStatus.OK);
                }
                knjigaService.delete(knjiga);
                return new ResponseEntity("Knjiga obrisana!", HttpStatus.OK);
            } else {
                return new ResponseEntity("Knjiga nije u bazi!", HttpStatus.CONFLICT);
            }
        }

        return new ResponseEntity("Samo administrator moze brisati knjige iz baze!", HttpStatus.CONFLICT);
    }


}





