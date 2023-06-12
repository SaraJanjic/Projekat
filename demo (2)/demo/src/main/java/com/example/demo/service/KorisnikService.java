package com.example.demo.service;

import com.example.demo.Entity.*;
import com.example.demo.Repository.KorisnikRepository;
import com.example.demo.dto.KnjigaDto;
import com.example.demo.dto.ProfilDto;
import com.example.demo.dto.RecenzijaDto;
import com.example.demo.dto.RegistracijaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;
    @Autowired
    private PolicaService policaService;

    @Autowired
    private StavkaPoliceService stavkaPoliceService;
    @Autowired
    private KnjigaService knjigaService;

    @Autowired
    private RecenzijaService recenzijaService;

    public Korisnik findOne(Long id) {
        Optional<Korisnik> foundKorisnik = korisnikRepository.findById(id);
        if (foundKorisnik.isPresent())
            return foundKorisnik.get();

        return null;
    }

    public List<Korisnik> findAll() {
        return korisnikRepository.findAll();
    }

    public Korisnik save(Korisnik korisnik) {
        return korisnikRepository.save(korisnik);
    }

    public ResponseEntity register(RegistracijaDto dto) {
        if (korisnikRepository.findByUserName(dto.getUserName()).isPresent())
            return new ResponseEntity("Vec postoji taj username.", HttpStatus.BAD_REQUEST);

        if (korisnikRepository.findByEmail(dto.getUserName()).isPresent())
            return new ResponseEntity("Vec postoji taj email.", HttpStatus.BAD_REQUEST);

        if (dto.getIme() == null || dto.getPrezime() == null || dto.getEmail() == null || dto.getUserName() == null || dto.getLozinka() == null)
            return new ResponseEntity("Fali vam neko polje.", HttpStatus.BAD_REQUEST);

        Korisnik korisnik = new Korisnik();
        korisnik.setIme(dto.getIme());
        korisnik.setPrezime(dto.getPrezime());
        korisnik.setUserName(dto.getUserName());
        korisnik.setEmail(dto.getEmail());
        korisnik.setLozinka(dto.getLozinka());
        korisnik.setUloga(Uloga.CITALAC);

        Set<Polica> police = new HashSet<>();
        police.add(policaService.kreirajPolicu("Read"));
        police.add(policaService.kreirajPolicu("Want to Read"));
        police.add(policaService.kreirajPolicu("Currently Reading"));

        korisnik.setKorisnickePolice(police);

        korisnikRepository.save(korisnik);
        return new ResponseEntity("Uspesna registracija.", HttpStatus.OK);
    }

    public Korisnik login(String email, String password) {
        Korisnik korisnik = korisnikRepository.getByEmail(email);
        if (korisnik == null || !korisnik.getLozinka().equals(password))
            return null;
        return korisnik;
    }

    public boolean dodajPolicuKorisniku(Long id, String imePolice) {
        List<Korisnik> korisnici = korisnikRepository.findAll();
        for (Korisnik user : korisnici) {
            if (user.getId() == id) {
                Set<Polica> police = user.getKorisnickePolice();
                police.add(policaService.napraviPolicu(imePolice));
                user.setKorisnickePolice(police);
                korisnikRepository.save(user);
            }
        }
        return true;
    }


    public boolean dodajKnjiguKorisnikuNaPolicu(Long id, String imeKnjige, String imePolice, int ocena, String tekst, LocalDate datum) {

        boolean uspeh = false;

        Optional<Korisnik> korisnikOptional = korisnikRepository.findById(id);
        if (korisnikOptional.isPresent()) {
            Korisnik korisnik = korisnikOptional.get();


            // Provera da li je knjiga već dodata na primarnu policu
            boolean knjigaNaPrimarnojPovucena = false;
            Set<Polica> police = korisnik.getKorisnickePolice();
            for (Polica p : police) {
                if (p.getNaziv().equals(imePolice) && p.getOznakaPolice().equals(true)) {
                    knjigaNaPrimarnojPovucena = true;
                    break;
                }
            }

            // Pronalaženje ili kreiranje nove police
            Polica ciljnaPolica = null;
            for (Polica p : korisnik.getKorisnickePolice()) {
                if (p.getNaziv().equals(imePolice)) {
                    ciljnaPolica = p;
                    break;
                }
            }
/*
            if (ciljnaPolica == null) {
                ciljnaPolica = new Polica();
                ciljnaPolica.setNaziv(imePolice);
                korisnik.getKorisnickePolice().add(ciljnaPolica);
            }
*/
            // Dodavanje stavke sa knjigom na ciljnu policu
            Set<StavkaPolice> stavke = ciljnaPolica.getStavke();
            StavkaPolice stavkaPolice = stavkaPoliceService.napraviStavku(imeKnjige);
            stavke.add(stavkaPolice);
            ciljnaPolica.setStavke(stavke);


            // Dodavanje recenzije u stavku
            if (imePolice.equals("Read")) {
                RecenzijaDto recenzijaDto = new RecenzijaDto(ocena, tekst, datum);
                Recenzija recenzija = new Recenzija();
                recenzija.setOcena(recenzijaDto.getOcena());
                recenzija.setTekst(recenzijaDto.getTekst());
                recenzija.setDatumRecenzije(recenzijaDto.getDatum());
                recenzijaService.save(recenzija);
                stavkaPolice.setRecenzija(recenzija);
                stavkaPoliceService.save(stavkaPolice);
                ciljnaPolica.setStavke(stavke);
            }

            korisnikRepository.save(korisnik);

            uspeh = true;
        }
        return uspeh;
    }


   /* public boolean dodajKnjiguKorisnikuNaPolicu(Long id, String imeKnjige, String imePolice) {
        boolean tacnost = false;

        List<Korisnik> korisnici = korisnikRepository.findAll();
        for (Korisnik k : korisnici) {
            if (k.getId() == id) {
                Set<Polica> police = k.getKorisnickePolice();
                for (Polica p : police) {
                    if (p.getOznakaPolice().equals(true)) {
                        if (p.getNaziv().equals(imePolice) && imePolice.equals("Read")) {
                            Set<StavkaPolice> stavke = p.getStavke();
                            stavke.add(stavkaPoliceService.napraviStavku(imeKnjige));
                            p.setStavke(stavke);
                            tacnost = true;
                            break;
                        }else if (){

                        }
                    }else{
                        tacnost = false;
                        break;
                    }
                }
                //k.setKorisnickePolice(police);
                korisnikRepository.save(k);
            }
        }
        return tacnost;
    }*/

    public Polica izbrisiPolicu(Long id, String naziv){
        List<Korisnik> korisnici = korisnikRepository.findAll();
        for(Korisnik user : korisnici){
            if(user.getId() == id){
                Set<Polica> police = user.getKorisnickePolice();
                for(Polica polica : police){
                    if(polica.getNaziv().equals(naziv) && polica.getOznakaPolice()==false){
                        user.getKorisnickePolice().remove(polica);
                        return  polica;
                    }
                }
            }
        }
        return  null;
    }

   public Korisnik findByEmail(String email) {
        return korisnikRepository.findByEmail(email).get();
    }


    public Korisnik findById(Long id) {
        return  korisnikRepository.findById(id).get();
    }
    public boolean azurirajProfil(Long id, ProfilDto profilDto, String trenutnaLozinka) {
        Optional<Korisnik> korisnikOptional = korisnikRepository.findById(id);
        if (korisnikOptional.isPresent()) {
            Korisnik korisnik = korisnikOptional.get();

            // Provera ispravnosti trenutne lozinke
            if (!korisnik.getLozinka().equals(trenutnaLozinka)) {
                return false;
            }

            // Ažuriranje podataka profila
            korisnik.setIme(profilDto.getIme());
            korisnik.setPrezime(profilDto.getPrezime());
            //korisnik.setDatumRodjenja(profilDto.getDatumRodjenja());
            korisnik.setSlikaKorisnika(profilDto.getProfilnaSlika());
            korisnik.setOpis(profilDto.getOpis());

            // Ažuriranje lozinke i email adrese ako su uneti
            if (profilDto.getNovaLozinka() != null && !profilDto.getNovaLozinka().isEmpty()) {
                korisnik.setLozinka(profilDto.getNovaLozinka());
            }
            if (profilDto.getNovaEmailAdresa() != null && !profilDto.getNovaEmailAdresa().isEmpty()) {
                korisnik.setEmail(profilDto.getNovaEmailAdresa());
            }

            // Čuvanje ažuriranog korisnika u bazi podataka
            korisnikRepository.save(korisnik);

            return true;
        }

        return false;
    }

    public boolean dodajKnjigu(KnjigaDto knjigaDto) {
        Knjiga knjiga = new Knjiga();
        knjiga.setNaslov(knjigaDto.getNaslov());
        // Postavite ostale atribute knjige prema potrebama

        knjigaService.save(knjiga);

        return true;
    }

    public boolean azurirajKnjigu(Long knjigaId, KnjigaDto knjigaDto) {
        Optional<Knjiga> knjigaOptional = knjigaService.findById(knjigaId);
        if (knjigaOptional.isPresent()) {
            Knjiga knjiga = knjigaOptional.get();

            knjiga.setNaslov(knjigaDto.getNaslov());
            // Ažurirajte ostale atribute knjige prema potrebama

            knjigaService.save(knjiga);

            return true;
        }
        return false;
    }

    public boolean obrisiKnjigu(Long knjigaId) {
        Optional<Knjiga> knjigaOptional = knjigaService.findById(knjigaId);
        if (knjigaOptional.isPresent()) {
            Knjiga knjiga = knjigaOptional.get();

            knjigaService.delete(knjiga);

            return true;
        }
        return false;
    }


}
