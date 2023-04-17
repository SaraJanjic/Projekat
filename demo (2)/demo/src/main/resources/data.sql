INSERT INTO KORISNIK (ime, prezime, user_name, email, lozinka, datum_rodjenja, opis, uloga) VALUES ('Smiljka', 'Trnjic', 'smiljka78', 'smiljka78@gmail.com', 'imenaunuka', '7/8/1978', 'Sta te ne stigne na Drini, stgne te na Cupriji!', CITALAC);
INSERT INTO KORISNIK (ime, prezime, user_name, email, lozinka, datum_rodjenja, opis, uloga) VALUES ('Jovanka', 'Miljusic', 'joca99', 'jovanka99@gmail.com', 'funthings', '1/3/1999', 'Volim macke!', AUTOR);

INSERT INTO ZAHTEV (email, telefon, poruka, datum_zahteva, status) VALUES ('jovanka99@gmail.com', '069450786', 'Izdajte mi knjigu', '1/4/2019', ODOBREN);

INSERT INTO AUTOR (aktivnost, id) VALUES (true, 2);

INSERT INTO ZANR (naziv_zanra) VALUES ('istorijski roman');
INSERT INTO ZANR (naziv_zanra) VALUES ('romansa');
INSERT INTO ZANR (naziv_zanra) VALUES ('komedija');

INSERT INTO KNJIGA (naslov, ISBN, datum_objavljivanja, brstrana, opis, zanr_id, ocena, autor_id) VALUES ('Cvece u basti', 1234, 2002-01-04, 260, '...', 2, 3.80, 2);

INSERT INTO POLICA (naziv, oznaka_police) VALUES ('Want to Read', true);
INSERT INTO POLICA (naziv, oznaka_police) VALUES ('Currently reading', true);
INSERT INTO POLICA (naziv, oznaka_police) VALUES ('Read', true);

INSERT INTO STAVKAPOLICE (knjiga_id, polica_id) VALUES (1, 1);

INSERT INTO RECENZIJA (ocena, tekst, datum_recenzije, korisnik_id, recenzija_id) VALUES (4, 'Svidelo mi se', 2020-03-01, 2, 1);


