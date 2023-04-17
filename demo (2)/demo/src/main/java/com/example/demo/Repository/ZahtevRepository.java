package com.example.demo.Repository;

import com.example.demo.Entity.Zahtev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZahtevRepository extends JpaRepository<Zahtev, Long> {

    Zahtev findZahtevById(long id );

}
