DROP DATABASE IF EXISTS MTO_DB;
CREATE DATABASE MTO_DB;
USE MTO_DB;


DROP TABLE IF EXISTS utente;
CREATE TABLE IF NOT EXISTS utente (
  username varchar(15),
  password varchar(20) not NULL,
  email varchar(50) unique not NULL,
  tipo varchar(40) not null, 
  nome varchar(20) not NULL,
  cognome varchar(20) not NULL,
  data_nascita date, 
  annoImmatricolazione varchar(9),
  CFU int(10),
  universita varchar(50),
  dipartimento varchar(25),
  azienda varchar(30),
  primary key (username),
  unique(username)
  );
  
  
DROP TABLE IF EXISTS tirocinio;
CREATE TABLE IF NOT EXISTS tirocinio(
 codiceID int(25) not null auto_increment,
 rif_utente varchar(15) not null,
 azienda varchar(20) not NULL,
 data_inizio date not null,
 data_fine date not null,
 luogo varchar(20) not null,
 tematica varchar(100) not null,
 descrizione varchar(500) not null,
 primary key (codiceID),
 foreign key(rif_utente) references utente(username)
 
  );
    
DROP TABLE IF EXISTS documento;
CREATE TABLE IF NOT EXISTS documento(
codiceID 		int(25) AUTO_INCREMENT,
nome 			varchar(20) not null,
rif_utente 	varchar(15) not null,
rif_tirocinio 	int(25) not null,
file 			mediumblob,
primary key (codiceID),
foreign key(rif_utente) references utente(username),
foreign key(rif_tirocinio) references tirocinio(codiceID)
);

DROP TABLE IF EXISTS firma;
CREATE TABLE IF NOT EXISTS firma(
rif_utente varchar(15) not null,
rif_documento int(25) not null,
valore boolean,
foreign key(rif_utente) references utente(username),
foreign key(rif_documento) references documento(codiceID)
);

ALTER TABLE documento AUTO_INCREMENT=0;

/* Popolamento database */

/* UTENTE */ 

INSERT INTO utente VALUES ('r.napo12', 'ciao', 'r.napo12@studenti.unisa.it', 'Studente', 'Rita', 'Napo', '1996-05-27', '2009/2010', '102', 'Unisa', 'Matematica', '');

INSERT INTO utente VALUES('uffstage.unisa', 'unisaTirocini', 'a.ceruso@unisa.it', 'Ufficio Stage & Tirocini', 'Antonio', 'Ceruso', '1985-12-21', null, null, 'Università degli Studi di Salerno', 'Informatica', null);

INSERT INTO utente VALUES('c.desantis', 'carlo123', 'c.desantis2@studenti.unisa.it', 'Studente', 'Carlo', 'De Santis', '1994-11-19', '2015/2016', 130, 'Università degli Studi di Salerno', 'Informatica', null);

INSERT INTO utente VALUES('s.latorre', 'salvatore234', 'slatorre@unisa.it', 'Tutor Interno', 'Salvatore', 'La Torre', '1954-02-09', null, null, 'Università degli Studi di Salerno', 'Informatica', null);

INSERT INTO utente VALUES('ericsson.resp', 'a12b34c56', 'g.fortunato@ericsson.it', 'Responsabile Azienda', 'Giovanni', 'Fortunato', '1974-10-10', null, null, null, null, 'Ericsson Pagani');

INSERT INTO utente VALUES('ericsson.tut', 'x98y76z54', 'a.demartino@ericsson.it', 'Tutor Esterno', 'Alessandra', 'De Martino', '1972-10-29', null, null, null, null, 'Ericsson Pagani');

/* TIROCINIO */

ALTER TABLE tirocinio AUTO_INCREMENT = 0;
INSERT INTO tirocinio VALUES (0, (SELECT username FROM Utente WHERE azienda='Ericsson Pagani' && tipo='Responsabile Azienda'), 
	'Ericsson Pagani', '2018-07-06', '2018-08-06', 'Pagani', 'Analisi statica del codice con tecniche sviluppate nell’ambito dei metodi formali',
	'L’obiettivo del tirocinio è di estrarre benchmarks, adattare tool di verifica e sperimentare le tecniche di verifica automatica 
    sul codice sviluppato da Ericsson. Individuare errori (bug) e criticità nel codice sviluppati da Ericsson. ');

/*select * from utente;*/
/*  utente (
  username varchar(15) not NULL,
  password varchar(20) not NULL,
  email varchar(50) unique not NULL,
  tipo varchar(40) not null, 
  nome varchar(20) not NULL,
  cognome varchar(20) not NULL,
  data_nascita date, 
  annoImmatricolazione varchar(9),
  CFU int(10),
  universita varchar(50),
  dipartimento varchar(25),
  azienda varchar(30),
  primary key (username),
  unique(username)*/