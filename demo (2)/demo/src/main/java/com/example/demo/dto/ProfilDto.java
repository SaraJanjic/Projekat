package com.example.demo.dto;

import java.time.LocalDate;

public class ProfilDto {
        private String ime;
        private String prezime;
        private LocalDate datumRodjenja;
        private String profilnaSlika;
        private String opis;
        private String trenutnaLozinka;
        private String novaLozinka;
        private String novaEmailAdresa;

        public ProfilDto(String ime, String prezime, LocalDate datumRodjenja, String profilnaSlika, String opis, String trenutnaLozinka, String novaLozinka, String novaEmailAdresa) {
            this.ime = ime;
            this.prezime = prezime;
            this.datumRodjenja = datumRodjenja;
            this.profilnaSlika = profilnaSlika;
            this.opis = opis;
            this.trenutnaLozinka = trenutnaLozinka;
            this.novaLozinka = novaLozinka;
            this.novaEmailAdresa = novaEmailAdresa;
        }

        public String getIme() {
            return ime;
        }

        public void setIme(String ime) {
            this.ime = ime;
        }

        public String getPrezime() {
            return prezime;
        }

        public void setPrezime(String prezime) {
            this.prezime = prezime;
        }

        public LocalDate getDatumRodjenja() {
            return datumRodjenja;
        }

        public void setDatumRodjenja(LocalDate datumRodjenja) {
            this.datumRodjenja = datumRodjenja;
        }

        public String getProfilnaSlika() {
            return profilnaSlika;
        }

        public void setProfilnaSlika(String profilnaSlika) {
            this.profilnaSlika = profilnaSlika;
        }

        public String getOpis() {
            return opis;
        }

        public void setOpis(String opis) {
            this.opis = opis;
        }

        public String getTrenutnaLozinka() {
            return trenutnaLozinka;
        }

        public void setTrenutnaLozinka(String trenutnaLozinka) {
            this.trenutnaLozinka = trenutnaLozinka;
        }

        public String getNovaLozinka() {
            return novaLozinka;
        }

        public void setNovaLozinka(String novaLozinka) {
            this.novaLozinka = novaLozinka;
        }

        public String getNovaEmailAdresa() {
            return novaEmailAdresa;
        }

        public void setNovaEmailAdresa(String novaEmailAdresa) {
            this.novaEmailAdresa = novaEmailAdresa;
        }
    }

