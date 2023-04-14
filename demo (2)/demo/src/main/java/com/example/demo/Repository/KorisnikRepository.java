package com.example.demo.Repository;

import com.example.demo.Model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    Korisnik findByUserName(String userName);

}
