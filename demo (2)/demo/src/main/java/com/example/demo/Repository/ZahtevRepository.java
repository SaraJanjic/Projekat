package com.example.demo.Repository;

import com.example.demo.Entity.Autor;
import com.example.demo.Entity.Zahtev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ZahtevRepository extends JpaRepository<Zahtev, Long> {
    Optional<Zahtev> findById(Long id);
}
