package com.example.demo.Repository;

import com.example.demo.Entity.Polica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicaRepository extends JpaRepository<Polica, Long> {
}
