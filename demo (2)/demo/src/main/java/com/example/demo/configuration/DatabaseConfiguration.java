package com.example.demo.configuration;

import com.example.demo.Entity.*;
import com.example.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.example.demo.Entity.Status.ODOBREN;
import static com.example.demo.Entity.Uloga.AUTOR;
import static com.example.demo.Entity.Uloga.CITALAC;

@Configuration
public class DatabaseConfiguration {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private KnjigaRepository knjigaRepository;

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private PolicaRepository policaRepository;

    @Autowired
    private RecenzijaRepository recenzijaRepository;

    @Autowired
    private StavkaPoliceRepository stavkaPoliceRepository;

    @Autowired
    private ZahtevRepository zahtevRepository;

    @Autowired
    private ZanrRepository zanrRepository;

    @Bean
    public boolean instantiate(){
//        Korisnik korisnik1 = new Korisnik("Smiljka", "Trnjic", "smiljka78", "smiljka78@gmail.com", "imenaunuka", "Sta te ne stigne na Drini, stgne te na Cupriji!", "slika1.jpg", CITALAC);
//        Korisnik korisnik2 = new Korisnik("Jovanka", "Miljusic", "joca99", "jovanka99@gmail.com", "funthings", "Volim macke!", "slika2.jpg", AUTOR);
//
//        Polica polica1 = new Polica("Currenty reading", true);
//        Polica polica2 = new Polica("Want to read", true);
//        Polica polica3 = new Polica("Read", true);
//
//       policaRepository.saveAll(List.of(polica1, polica2, polica3));
//
//        korisnik1.getKorisnickePolice().add(polica1);
//        korisnik1.getKorisnickePolice().add(polica2);
//        korisnik1.getKorisnickePolice().add(polica3);
//
//        korisnik2.getKorisnickePolice().add(polica1);
//        korisnik2.getKorisnickePolice().add(polica2);
//        korisnik2.getKorisnickePolice().add(polica3);
//
//        korisnikRepository.saveAll(List.of(korisnik1, korisnik2));
//
//       Zanr zanr1 = new Zanr("istorijski roman");
//       Zanr zanr2 = new Zanr("ljubavni roman");
//
//       zanrRepository.saveAll(List.of(zanr1, zanr2));
//
//        Recenzija recenzija1 = new Recenzija(4, "veoma inspirativno"); //'2020-04-05');
//        Recenzija recenzija2 = new Recenzija(3, "solidno"); //'2021-06-01');
//
//        recenzijaRepository.saveAll(List.of(recenzija1, recenzija2));
//
//        Zahtev zahtev = new Zahtev("jovanka99@gmail.com", "069450786", "Izdajte mi knjigu", ODOBREN);
//
//        zahtevRepository.save(zahtev);
//
//        Autor autor = new Autor("Jovanka", "Miljusic", "joca99", "jovanka99@gmail.com", "funthings", "Volim macke!", "slika2.jpg", AUTOR, true);
//        autor.getKorisnickePolice().add(polica1);
//        autor.getKorisnickePolice().add(polica2);
//        autor.getKorisnickePolice().add(polica3);
//
//        autorRepository.save(autor);
//
//        Knjiga knjiga = new Knjiga("Cvece u basti", "1234", 260, "...", "slika knjige", 3.8);
//        knjiga.setZanr(zanr2);
//        knjiga.setAutor(autor);
//
//        knjigaRepository.save(knjiga);
//
//        StavkaPolice stavkaPolice = new StavkaPolice(knjiga, recenzija2);
//        stavkaPolice.getPolice().add(polica1);
//        stavkaPolice.getPolice().add(polica2);
//        stavkaPolice.getPolice().add(polica3);
//
//        stavkaPoliceRepository.save(stavkaPolice);

        /*
        Korisnik korisnik = new Korisnik();
        korisnik.setIme("admin");
        korisnik.setPrezime("admin");
        korisnik.setEmail("admin");
        korisnik.setLozinka("admin123");
        korisnik.setUserName("admin");
        korisnik.setUloga(Uloga.ADMINISTRATOR);
        korisnikRepository.save(korisnik);
        korisnik.setId(null);
        korisnik.setIme("admin1");
        korisnik.setPrezime("admin1");
        korisnik.setEmail("admin1");
        korisnik.setLozinka("admin1234");
        korisnik.setUserName("admin1");
        korisnik.setUloga(CITALAC);
        korisnikRepository.save(korisnik);
        korisnik.setId((long)1);
        korisnik.setIme("admin");
        korisnik.setPrezime("prezime");
        korisnik.setEmail("admin");
        korisnik.setLozinka("admin123");
        korisnik.setUserName("admin");
        korisnik.setUloga(Uloga.ADMINISTRATOR);
        korisnikRepository.save(korisnik);
        */
        return true;
    }




}
