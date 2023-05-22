package com.example.demo.Repository;

import com.example.demo.Entity.Korisnik;
import com.example.demo.Entity.Polica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PolicaRepository extends JpaRepository<Polica, Long> {
    Optional<Polica> findByNaziv(String naziv);
}
