package com.example.demo.controller;

import com.example.demo.Entity.Knjiga;
import com.example.demo.Entity.Korisnik;
import com.example.demo.dto.KorisnikDto;
import com.example.demo.dto.LoginDto;
import com.example.demo.servis.KorisnikService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class KorisnikRestController {

        // @Autowired
        private KorisnikService korisnikService;

        @GetMapping("/api/")
        public String welcome(){
            return "Hello from api!";
        }

        @PostMapping("api/login")
        public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpSession session){
            // proverimo da li su podaci validni
            if(loginDto.getEmail().isEmpty() || loginDto.getPassword().isEmpty())
                return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);

            Korisnik loggedKorisnik = korisnikService.login(loginDto.getEmail(), loginDto.getPassword());
            if (loggedKorisnik == null)
                return new ResponseEntity<>("User does not exist!", HttpStatus.NOT_FOUND);

            session.setAttribute("korisnik", loggedKorisnik);
            return ResponseEntity.ok("Successfully logged in!");
        }

        @PostMapping("api/logout")
        public ResponseEntity Logout(HttpSession session){
            Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");

            if (loggedKorisnik == null)
                return new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);

            session.invalidate();
            return new ResponseEntity("Successfully logged out", HttpStatus.OK);
        }

        @GetMapping("/api/korisnik")
        public ResponseEntity<List<KorisnikDto>> getKorisnik(HttpSession session){
            List<Korisnik> korisnikList = korisnikService.findAll();

            Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
            if(loggedKorisnik == null) {
                System.out.println("Nema sesije");
            } else {
                System.out.println(loggedKorisnik);
            }

            List<KorisnikDto> dtos = new ArrayList<>(); //objasniti
            for(Korisnik korisnik : korisnikList){
                KorisnikDto dto = new KorisnikDto(korisnik);
                dtos.add(dto);
            }
            return ResponseEntity.ok(dtos);
        }

        @GetMapping("/api/korisnik/{id}")
        public Korisnik getKorisnik(@PathVariable(name = "id") Long id, HttpSession session){
            Korisnik korisnik = (Korisnik) session.getAttribute("user");
            System.out.println(korisnik.getUserName()); //getIme
            session.invalidate();
            return korisnikService.findOne(id);
        }
      /* @GetMapping("api/knjiga/{naziv}")
        public Knjiga getKnjiga(@PathVariable(name = "naziv") String naslov, HttpSession session) {
           Knjiga knjiga = (Knjiga) session.getAttribute(naslov);
           System.out.println(knjiga.getNaslov()); //getIme
            session.invalidate();
            return korisnikService.findOne(naslov);
        }*/

        @PostMapping("/api/save-korisnik")
        public String saveKorisnik(@RequestBody Korisnik korisnik) {
            this.korisnikService.save(korisnik);
            return "Successfully saved a user!";
        }
    }


