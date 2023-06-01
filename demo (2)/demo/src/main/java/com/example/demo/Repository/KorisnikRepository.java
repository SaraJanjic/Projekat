package com.example.demo.Repository;

import com.example.demo.Entity.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    Korisnik getByEmail(String email);

    Optional<Korisnik> findById(Long id);

    Optional<Korisnik> findByUserName(String username);
    Optional<Korisnik> findByEmail(String email);

}
