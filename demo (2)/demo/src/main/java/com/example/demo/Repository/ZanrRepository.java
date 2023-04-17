package com.example.demo.Repository;

import com.example.demo.Entity.Zanr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZanrRepository extends JpaRepository<Zanr, Long>{

    Zanr findById(long id);

}
