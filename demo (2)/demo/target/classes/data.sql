INSERT INTO KORISNIK (ime, prezime, user_name, email, lozinka, datum_rodjenja, opis, slika_korisnika, uloga) VALUES ('Smiljka', 'Trnjic', 'smiljka78', 'smiljka78@gmail.com', 'imenaunuka', '1997-05-06', 'Sta te ne stigne na Drini, stgne te na Cupriji!', 'slika1.jpg',  'CITALAC');
INSERT INTO KORISNIK (ime, prezime, user_name, email, lozinka, datum_rodjenja, opis, slika_korisnika, uloga) VALUES ('Jovanka', 'Miljusic', 'joca99', 'jovanka99@gmail.com', 'funthings', '1980-07-08', 'Volim macke!', 'slika2.jpg', 'AUTOR');

INSERT INTO ZAHTEV (email, telefon, poruka, datum_zahteva, status) VALUES ('jovanka99@gmail.com', '069450786', 'Izdajte mi knjigu', '2020-04-05', 'ODOBREN');

INSERT INTO AUTOR (aktivnost, id) VALUES (true, 2);

INSERT INTO ZANR (naziv_zanra) VALUES ('istorijski roman');
INSERT INTO ZANR (naziv_zanra) VALUES ('romansa');
INSERT INTO ZANR (naziv_zanra) VALUES ('komedija');

INSERT INTO KNJIGA (naslov, ISBN, datum_objavljivanja, br_strana, opis, naslovna_slika, zanr_id, ocena, autor_id) VALUES ('Cvece u basti', 1234, '2002-01-04', 260, '...', 'slika knjige', 2, 3.80, 2);

INSERT INTO POLICA (naziv, oznaka_police) VALUES ('Want to Read', true);
INSERT INTO POLICA (naziv, oznaka_police) VALUES ('Currently reading', true);
INSERT INTO POLICA (naziv, oznaka_police) VALUES ('Read', true);

INSERT INTO RECENZIJA (ocena, tekst, datum_recenzije, korisnik_id) VALUES (4, 'Svidelo mi se', '2020-03-01', 2);

INSERT INTO STAVKA_POLICE (knjiga_id, polica_id, recenzija_id) VALUES (1, 3, 1);


