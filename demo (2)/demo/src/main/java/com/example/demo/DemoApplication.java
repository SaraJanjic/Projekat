package com.example.demo;

import com.example.demo.Model.Korisnik;
import com.example.demo.Repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private KorisnikRepository korisnikRepository;

	@Override
	public void run(String... args) {

		// kreiramo novi objekat klase Korisnik
		Korisnik korisnik = new Korisnik();
		korisnik.setIme("Lena");
		korisnik.setPrezime("Reljic");
		korisnik.setUserName("lenar1");
		korisnik.setEmail("lenar1@gmail.com");
		korisnik.setLozinka("loooooozinka");
		korisnik.setDatumRodjenja("31/08/2002");
		//korisnik.setUloga(CITALAC);


		// čuvamo objekat u bazi
		this.korisnikRepository.save(korisnik);

		List<Korisnik> korisnici = this.korisnikRepository.findAll();

		for (Korisnik k : korisnici){
			System.out.println(k);
		}
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


}
