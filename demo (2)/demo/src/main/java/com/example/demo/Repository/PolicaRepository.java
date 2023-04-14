package com.example.demo.Repository;

import com.example.demo.Model.Polica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.security.SecureRandom;

public interface PolicaRepository extends JpaRepository<Polica, Long> {

    Polica findByNaziv(String naziv);



}
