package com.example.demo.Repository;

import com.example.demo.Model.Recenzija;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecenzijaRepository extends JpaRepository<Recenzija, Long> {

    Recenzija findByOcena(int ocena);


}
