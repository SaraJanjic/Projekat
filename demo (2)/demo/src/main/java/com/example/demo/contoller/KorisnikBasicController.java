package com.example.demo.contoller;

import com.example.demo.Entity.Korisnik;
import com.example.demo.dto.LoginDto;
import com.example.demo.servis.KorisnikService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class KorisnikBasicController {
    //@Autowired
    private KorisnikService korisnikService;

    @GetMapping("/hello")
    public String welcome(){
        return "index.html";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/login-form";
    }

    @GetMapping("/login-form")
    public String login(Model model) {
        LoginDto loginDto = new LoginDto();
        model.addAttribute("login", loginDto);
        return "login.html";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDto loginDto, HttpSession session){
        // proverimo da li su podaci validni
        if(loginDto.getEmail().isEmpty() || loginDto.getPassword().isEmpty())
            return "redirect:/login-form";

        Korisnik korisnik = korisnikService.login(loginDto.getEmail(), loginDto.getPassword());
        if (korisnik == null)
            return "redirect:/login-form";

        session.setAttribute("korisnik", korisnik);
        return "redirect:/hello";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login-form";
    }

    @GetMapping("/korisnik")
    public String getKorisnik(Model model, HttpSession session){
        List<Korisnik> KorisnikList = korisnikService.findAll();
        model.addAttribute("korisnik", KorisnikList);

        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(loggedKorisnik == null) {
            System.out.println("Nema sesije");
        } else {
            System.out.println(loggedKorisnik);
        }

        return "korisnik.html";
    }

    @GetMapping("/korisnik/{id}")
    public String getKorisnik(@PathVariable(name = "id") Long id, Model model, HttpSession session){
        Korisnik korisnik = korisnikService.findOne(id);
        model.addAttribute("korisnik", korisnik);
        return "korisnik.html";
    }

    @GetMapping("/add-employee")
    public String addKorisnik(Model model) {
        Korisnik korisnik = new Korisnik();
        model.addAttribute("korisnik", korisnik);
        return "add-korisnik.html";
    }

    @PostMapping("/save-employee")
    public String saveKorisnik(@ModelAttribute Korisnik korisnik) {
        this.korisnikService.save(korisnik);
        return "redirect:/korisnik";
    }
}
