package com.example.demo.Repository;

import com.example.demo.Entity.Korisnik;
import com.example.demo.Entity.Recenzija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecenzijaRepository extends JpaRepository<Recenzija, Long> {
    Optional<Recenzija> findByOcena(int ocena);
}
