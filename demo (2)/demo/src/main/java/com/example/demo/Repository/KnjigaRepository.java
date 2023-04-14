package com.example.demo.Repository;

import com.example.demo.Model.Knjiga;
import com.example.demo.Model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KnjigaRepository extends JpaRepository<Knjiga, Long> {

    Knjiga findKnjigaByNaslov(String naslov);

}
