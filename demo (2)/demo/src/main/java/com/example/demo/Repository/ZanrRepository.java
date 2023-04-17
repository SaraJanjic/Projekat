package com.example.demo.Repository;

import com.example.demo.Model.Zanr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZanrRepository extends JpaRepository<Zanr, Long>{

    Zanr findById(long id);

}
