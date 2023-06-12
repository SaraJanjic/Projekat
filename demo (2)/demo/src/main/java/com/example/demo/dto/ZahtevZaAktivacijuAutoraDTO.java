package com.example.demo.dto;

import com.example.demo.Entity.Status;
import com.example.demo.Entity.ZahtevZaAktivacijuAutora;

public class ZahtevZaAktivacijuAutoraDTO {

        private Status statusl;

        private String email;
        private int brojTelefona;
        private String dodatnaPoruka;


    public ZahtevZaAktivacijuAutoraDTO(Status statusl, String email, int brojTelefona, String dodatnaPoruka) {
        this.statusl = statusl;
        this.email = email;
        this.brojTelefona = brojTelefona;
        this.dodatnaPoruka = dodatnaPoruka;
    }

    public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }


        public int getBrojTelefona() {
            return brojTelefona;
        }

        public void setBrojTelefona(int brojTelefona) {
            this.brojTelefona = brojTelefona;
        }

        public String getDodatnaPoruka() {
            return dodatnaPoruka;
        }

        public void setDodatnaPoruka(String dodatnaPoruka) {
            this.dodatnaPoruka = dodatnaPoruka;
        }

    public Status getStatusl() {
        return statusl;
    }

    public void setStatusl(Status statusl) {
        this.statusl = statusl;
    }
}
