package com.example.demo.Repository;

import com.example.demo.Model.Zahtev;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZahtevRepository extends JpaRepository<Zahtev, Long> {

    Zahtev findZahtevById(long id );

}
