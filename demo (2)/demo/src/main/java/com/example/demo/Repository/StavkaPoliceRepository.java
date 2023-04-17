package com.example.demo.Repository;

import com.example.demo.Model.Knjiga;
import com.example.demo.Model.StavkaPolice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StavkaPoliceRepository extends JpaRepository<StavkaPolice, Long> {


    StavkaPolice findById(long id);
}
