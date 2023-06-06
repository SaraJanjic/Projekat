package com.example.demo.service;

import com.example.demo.Entity.Knjiga;
import com.example.demo.Entity.Korisnik;
import com.example.demo.Entity.Polica;
import com.example.demo.Entity.Uloga;
import com.example.demo.Repository.KnjigaRepository;
import com.example.demo.Repository.PolicaRepository;
import com.example.demo.dto.PolicaDto;
import com.example.demo.dto.RegistracijaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PolicaService {
    @Autowired
    private PolicaRepository policaRepository;
    @Autowired
    private KnjigaRepository knjigaRepository;



    /*public Polica findOne(Long id){
        Optional<Polica> foundPolica = policaRepository.findById(id);
        if (foundPolica.isPresent())
            return foundPolica.get();

        return null;
    }*/

    public List<Polica> findAll(){
        return policaRepository.findAll();
    }

    public Polica save(Polica polica){ return policaRepository.save(polica);
    }

    public Polica kreirajPolicu(String naziv) {
        Polica polica = new Polica();
        polica.setNaziv(naziv);
        polica.setOznakaPolice(true);
        save(polica);
        return polica;
    }

/*
    public Police napraviPolicu(PolicaDto dto) {

        if (policaRepository.findByNaziv(dto.getNaziv()).isPresent()) {
            return new ResponseEntity("Vec postoji ta polica.", HttpStatus.BAD_REQUEST);
        }

        if (dto.getNaziv() == null)
            return new ResponseEntity("Fali vam neko polje.", HttpStatus.BAD_REQUEST);

        Polica polica = new Polica();
        polica.setNaziv(dto.getNaziv());
        polica.setOznakaPolice(false);

        policaRepository.save(polica);
        return new ResponseEntity("Uspesno pravljenje police.", HttpStatus.OK);
    }
*/
    public String deletePolica(String naziv) {
        Optional<Polica> policaO = policaRepository.findByNaziv(naziv);
            if(policaO.isPresent()){
                Polica polica = policaO.get();
                policaRepository.delete(polica);
                return "Polica je obrisana.";
             }else{
                //throw new PolicaNotFoundException("POlica nije nadjena." + naziv);
                return "Polica ne postoji.";
            }
        }

        /*
    public Polica napraviPolicu(PolicaDto policaDto){
        Polica polica = new Polica();
        polica.setNaziv(policaDto.getNaziv());
        polica.setOznakaPolice(false);
        return policaRepository.save(polica);
    }
    */

    public Polica napraviPolicu(String name){
        Optional<Polica> postojecaPolica = policaRepository.findByNaziv(name);
        if(postojecaPolica.isPresent()){
            return  null;
        }
        Polica polica = new Polica();
        polica.setNaziv(name);
        polica.setOznakaPolice(false);
        return policaRepository.save(polica);
    }

    public boolean dodajKnjiguNaPolicu(String name, String naziv){
        Knjiga knjiga = knjigaRepository.findByNaslov(name);
            if(knjiga==null){
                return false;
            }
            Optional<Polica> polica=policaRepository.findByNaziv(naziv);
            if(polica==null){
                return false;
            }

        if(polica.get().getOznakaPolice() == true && polica.get().getKnjige().contains(knjiga)){
            return false;
        }

    polica.get().getKnjige().add(knjiga);
    policaRepository.save(polica.get());
    return true;
    }

}
