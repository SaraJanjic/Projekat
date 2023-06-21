package com.example.demo.Repository;

import com.example.demo.Entity.Autor;
import com.example.demo.Entity.Knjiga;
import com.example.demo.Entity.StavkaPolice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StavkaPoliceRepository extends JpaRepository<StavkaPolice, Long> {
    Optional<StavkaPolice> findByKnjiga(Knjiga knjiga); //da li moze ovako?

    //default void delete(Long id, Long id1) {
    //}
}
