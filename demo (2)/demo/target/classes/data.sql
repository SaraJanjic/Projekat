
//insert into korisnik (ime, prezime, user_name, lozinka, email, uloga) values ('admin', 'nimda', 'admin', 'admin123', 'email', 'ADMINISTRATOR');

INSERT INTO KORISNIK (ime, prezime, user_name, email, lozinka, datum_rodjenja, opis, slika_korisnika, uloga) VALUES ('Smiljka', 'Trnjic', 'smiljka78', 'smiljka78@gmail.com', 'imenaunuka', '1997-05-06', 'Sta te ne stigne na Drini, stgne te na Cupriji!', 'slika1.jpg',  'ADMINISTRATOR');
INSERT INTO KORISNIK (ime, prezime, user_name, email, lozinka, datum_rodjenja, opis, slika_korisnika, uloga) VALUES ('Jovanka', 'Miljusic', 'joca99', 'jovanka99@gmail.com', 'funthings', '1980-07-08', 'Volim macke!', 'slika2.jpg', 'AUTOR');
INSERT INTO KORISNIK (ime, prezime, user_name, email, lozinka, datum_rodjenja, opis, slika_korisnika, uloga) VALUES ('Dzoana', 'Rouling', 'Dzej-Kej', 'rouling@gmail.com', 'hariii', '1965-07-31', 'Serijal!', 'slika2.jpg', 'AUTOR');
INSERT INTO KORISNIK (ime, prezime, user_name, email, lozinka, datum_rodjenja, opis, slika_korisnika, uloga) VALUES ('Dzon', 'Tolkin', 'Dzon', 'tolkin@gmail.com', 'prsten', '1892-01-03', 'Nestvarno!', 'slika2.jpg', 'AUTOR');

//INSERT INTO ZAHTEV (email, telefon, poruka, datum_zahteva, status) VALUES ('jovanka99@gmail.com', '069450786', 'Izdajte mi knjigu', '2020-04-05', 'ODOBREN');

INSERT INTO AUTOR (aktivnost, id) VALUES (true, 2);
INSERT INTO AUTOR (aktivnost, id) VALUES (true, 3);
INSERT INTO AUTOR (aktivnost, id) VALUES (true, 4);

INSERT INTO ZANR (naziv_zanra) VALUES ('istorijski roman');
INSERT INTO ZANR (naziv_zanra) VALUES ('romansa');
INSERT INTO ZANR (naziv_zanra) VALUES ('komedija');
INSERT INTO ZANR (naziv_zanra) VALUES ('fikcija');

INSERT INTO KNJIGA (naslov, ISBN, datum_objavljivanja, br_strana, opis, naslovna_slika, zanr_id, ocena, autor_id) VALUES ('Cvece u basti', 1234, '2002-01-04', 260, '...', 'slika knjige', 2, 3.80, 2);
INSERT INTO KNJIGA (naslov, ISBN, datum_objavljivanja, br_strana, opis, naslovna_slika, zanr_id, ocena, autor_id) VALUES ('Hari Poter', 2345, '1997-06-26', 400, '...', 'slika knjige', 4, 5.00, 3);
INSERT INTO KNJIGA (naslov, ISBN, datum_objavljivanja, br_strana, opis, naslovna_slika, zanr_id, ocena, autor_id) VALUES ('Gospodar Prstenova', 3456, '1954-11-11', 700, '...', 'slika knjige', 4, 4.90, 4);

INSERT INTO RECENZIJA (ocena, tekst, datum_recenzije, korisnik_id) VALUES (4, 'Svidece ti se!', '2020-03-01', 2);
INSERT INTO RECENZIJA (ocena, tekst, datum_recenzije, korisnik_id) VALUES (5, 'Odlicna!', '2022-06-19', 3);
INSERT INTO RECENZIJA (ocena, tekst, datum_recenzije, korisnik_id) VALUES (5, 'Preporucujem!', '2019-04-20', 4);


INSERT INTO STAVKA_POLICE (knjiga_id, recenzija_id) VALUES (1, 1);
INSERT INTO STAVKA_POLICE (knjiga_id, recenzija_id) VALUES (2, 2);
INSERT INTO STAVKA_POLICE (knjiga_id, recenzija_id) VALUES (3, 3);

