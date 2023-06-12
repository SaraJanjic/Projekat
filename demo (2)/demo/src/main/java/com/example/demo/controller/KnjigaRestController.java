package com.example.demo.controller;

import com.example.demo.Entity.Autor;
import com.example.demo.Entity.Knjiga;
import com.example.demo.Entity.Korisnik;
import com.example.demo.Entity.Zanr;
import com.example.demo.dto.DodavanjeKnjigeNaPolicuDto;
import com.example.demo.dto.KnjigaDto;
import com.example.demo.dto.KorisnikDto;
import com.example.demo.service.AutorService;
import com.example.demo.service.KnjigaService;
import com.example.demo.service.KorisnikService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class KnjigaRestController {

    @Autowired
    private KnjigaService knjigaService;

    @Autowired
    private AutorService autorService;

    @Autowired
    KorisnikService korisnikService;

    @GetMapping("/api/traziKnjiguPoId/{id}") //trazi knjigu po id-u
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
    public ResponseEntity<?> dodajKnjigu(@RequestBody KnjigaDto knjigaDto) {
        Knjiga knjiga = new Knjiga();
        knjiga.setNaslov(knjigaDto.getNaslov());
        knjiga.setZanr(knjigaDto.getZanr());
        knjiga.setOpis(knjigaDto.getOpis());
        knjiga.setNaslovnaSlika(knjigaDto.getNaslovnaSlika());

        knjigaService.save(knjiga);

        return ResponseEntity.ok().build();
    }

    // Metoda za ažuriranje knjige
    @PutMapping("/azuriranje-knjige/{knjigaId}")
    public ResponseEntity<?> azurirajKnjigu(@PathVariable Long knjigaId, @RequestBody KnjigaDto knjigaDto) {
        Optional<Knjiga> knjigaOptional = knjigaService.findById(knjigaId);
        if (knjigaOptional.isPresent()) {
            Knjiga knjiga = knjigaOptional.get();

            knjiga.setNaslov(knjigaDto.getNaslov());
           knjiga.setZanr(knjigaDto.getZanr());
            knjiga.setOpis(knjigaDto.getOpis());
            knjiga.setNaslovnaSlika(knjigaDto.getNaslovnaSlika());

            knjigaService.save(knjiga);

            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/brisanje-knjige-iz-baze/{knjigaId}")
    public ResponseEntity<?> obrisiKnjigu(@PathVariable (name="knjigaId") Long knjigaId) {
        Optional<Knjiga> knjigaOptional = knjigaService.findById(knjigaId);
        if (knjigaOptional.isPresent()) {
            Knjiga knjiga = knjigaOptional.get();
            knjigaService.delete(knjiga);

            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

/*
 @PostMapping("/api/knjigedodavanje") //admin dodaje knjigu, probati
    public ResponseEntity<String> dodajKnjigu(@RequestBody KnjigaDto knjigaDto, KorisnikDto korisnikDto) {

        korisnikDto.setEmail(korisnikDto.getEmail());
        korisnikDto.setLozinka(korisnikDto.getLozinka());

        if (korisnikDto.getUloga().equals("CITALAC") )
            return new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);

        Knjiga knjiga = new Knjiga();

        knjiga.setNaslov(knjigaDto.getNaslov());
        // knjiga.setAutor(knjigaDto.getAutor());

        knjigaService.save(knjiga);

        return ResponseEntity.ok("Knjiga uspešno dodata.");
    }



    @PostMapping("/{id}/dodaj-knjigu-na-policu")

    public ResponseEntity<String> dodajKnjiguNaPolicu(

            @PathVariable Long id,

            @RequestParam String imeKnjige,

            @RequestParam String imePolice,

            @RequestParam(required = false) List<Date> datumi,

            @RequestParam(required = false) Integer ocena,

            @RequestParam(required = false) String misljenje

    ) {

        boolean uspeh = korisnikService.dodajKnjiguKorisnikuNaPolicu(id, imeKnjige, imePolice, datumi, ocena, misljenje);

        if (uspeh) {

            return ResponseEntity.ok("Knjiga je uspešno dodata korisniku na policu.");

        } else {

            return ResponseEntity.badRequest().body("Dodavanje knjige korisniku na policu nije uspelo.");

        }

    }

}
*/



