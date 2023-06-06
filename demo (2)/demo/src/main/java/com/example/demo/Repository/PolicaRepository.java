package com.example.demo.Repository;

import com.example.demo.Entity.Korisnik;
import com.example.demo.Entity.Polica;
import com.example.demo.dto.PolicaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PolicaRepository extends JpaRepository<Polica, Long> {
    //static Polica save(PolicaDto dto) {
      //  return null;
    //}

    /*@Query("SELECT p FROM Polica p JOIN p.knjige k WHERE k.naslov= :naslov AND k.jelPrimarna=true")
    Polica findPrimaryByBook(@Param("naslov") String naslov);*/

    Optional<Polica> findByNaziv(String naziv);
    //Polica findByNazivNeOptional(String naziv);
    //Polica findById(Long id);
}
