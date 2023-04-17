package com.example.demo.Repository;

import com.example.demo.Entity.Knjiga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnjigaRepository extends JpaRepository<Knjiga, Long> {

    Knjiga findKnjigaById(long id);

}
