package com.example.demo.Repository;

import com.example.demo.Entity.StavkaPolice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StavkaPoliceRepository extends JpaRepository<StavkaPolice, Long> {
}
