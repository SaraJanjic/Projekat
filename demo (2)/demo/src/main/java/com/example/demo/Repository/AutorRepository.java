package com.example.demo.Repository;

import com.example.demo.Entity.Autor;
import com.example.demo.Entity.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Korisnik, Long> {
    Optional<Autor> findByUserName(String username);
    Optional<Korisnik> findById(Long id);
}

