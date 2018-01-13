DROP DATABASE IF EXISTS MTO_DB;
CREATE DATABASE MTO_DB;
USE MTO_DB;


DROP TABLE IF EXISTS utente;
CREATE TABLE IF NOT EXISTS utente (
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
  unique(username)
  );
  
  
DROP TABLE IF EXISTS tirocinio;
CREATE TABLE IF NOT EXISTS tirocinio(
 codiceID int(25) not null,
 rif_utente varchar(15) not null,
 azienda varchar(20) not NULL,
 data_inizio date not null,
 data_fine date not null,
 luogo varchar(20) not null,
 tematica varchar(50) not null,
 descrizione varchar(150) not null,
 primary key (codiceID),
 foreign key(rif_utente) references utente(username)
 
  );
  
  
  
DROP TABLE IF EXISTS documento;
CREATE TABLE IF NOT EXISTS documento(
 codiceID 		int(25) AUTO_INCREMENT,
 nome 			varchar(20) not NULL,
 rif_utente 	varchar(15) not null,
 rif_tirocinio 	int(15) not null,
 file 			mediumblob ,
 primary key (codiceID)
 /*foreign key(rif_utente) references utente(username),
 foreign key(rif_tirocinio) references tirocinio(codiceID)*/
  )ENGINE=InnoDB DEFAULT CHARSET=latin1;  
  
  
DROP TABLE IF EXISTS firma;
CREATE TABLE IF NOT EXISTS firma(
rif_utente varchar(15) not null,
rif_documento int(25) not null,
valore boolean
/*foreign key(rif_utente) references utente(username),
foreign key(rif_documento) references documento(codiceID)*/
);

ALTER TABLE documento AUTO_INCREMENT=0;
  
INSERT INTO utente VALUES ('r.napo12', 'ciao', 'r.napo12@studenti.unisa.it', 'studente', 'Rita', 'Napo', '1996-05-27', '2009/2010', '102', 'Unisa', 'Matematica', '');

select * from utente;
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