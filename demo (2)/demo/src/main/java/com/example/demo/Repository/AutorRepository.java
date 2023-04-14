package com.example.demo.Repository;

import com.example.demo.Model.Autor;
import com.example.demo.Model.Korisnik;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.function.Function;

public interface AutorRepository extends JpaRepository<Korisnik, Long> {

   Autor findByUserName(String userName);

}
