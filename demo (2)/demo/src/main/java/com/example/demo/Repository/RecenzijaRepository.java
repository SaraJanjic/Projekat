package com.example.demo.Repository;

import com.example.demo.Entity.Recenzija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecenzijaRepository extends JpaRepository<Recenzija, Long> {
}
