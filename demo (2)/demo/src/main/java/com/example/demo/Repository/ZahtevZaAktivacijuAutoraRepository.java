package com.example.demo.Repository;

import com.example.demo.Entity.ZahtevZaAktivacijuAutora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ZahtevZaAktivacijuAutoraRepository extends JpaRepository<ZahtevZaAktivacijuAutora, Long> {
    Optional<ZahtevZaAktivacijuAutora> findById(Long id);

    Optional<ZahtevZaAktivacijuAutora> findByStatus(String status);

}


