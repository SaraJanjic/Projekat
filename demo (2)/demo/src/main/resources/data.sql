INSERT INTO KORISNIK (ime, prezime, userName, email, lozinka, datumRodjenja, opis, uloga) VALUES ('Smiljka', 'Trnjic', 'smiljka78', 'smiljka78@gmail.com', 'imenaunuka', '7/8/1978', 'Sta te ne stigne na Drini, stgne te na Cupriji!', KORISNIK);

INSERT INTO AUTOR (ime, prezime, userName, email, lozinka, datumRodjenja, opis, uloga, aktivnost, knjige) VALUES ('Ivo', 'Andric', 'IvoAndric', 'Ivo.Andric@gmail.com', 'neznanje', '9/10/1892', 'Autor romana "Na Drini Cuprija!', AUTOR, NEAKTIVAN, 'Na Drini Cuprija');

INSERT INTO KNJIGA (naslov, ISBN, datumObjavljivanja, brstrana, opis, zanr, ocena) VALUES ('Na Drini Cuprija', 1234, 1/1/1945, 350, 'Patnja bosanskog naroda na pocetku...', 'istorijski roman', 4.33);
INSERT INTO ZANR (nazivZanra) VALUES ('istorijski roman');
INSERT INTO ZANR (nazivZanra) VALUES ('romansa');
INSERT INTO ZANR (nazivZanra) VALUES ('komedija');




/*
INSERT INTO POLICA (naziv, oznakaPolice, stavka) VALUES ('Want to Read', true, );

INSERT INTO STAVKAPOLICE (recenzija, knjiga) VALUES ();

INSERT INTO POLICA (naziv, oznakaPolice, stavka) VALUES ('Want to Read', true, );
*/