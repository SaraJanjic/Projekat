package com.example.demo.Repository;

import com.example.demo.Entity.Autor;
import com.example.demo.Entity.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Korisnik, Long> {

   Autor findAllBy(long id);

}

