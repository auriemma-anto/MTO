DROP DATABASE IF EXISTS MTO_DB;
CREATE DATABASE MTO_DB;
USE MTO_DB;


DROP TABLE IF EXISTS utente;
CREATE TABLE IF NOT EXISTS utente (
  username varchar(16) not NULL,
  password varchar(26) not NULL,
  email varchar(50) not NULL,
  tipo varchar(40) not null, 
  nome varchar(26) not NULL,
  cognome varchar(26) not NULL,
  data_nascita date, 
  annoImmatricolazione varchar(9),
  CFU int(10),
  universita varchar(50),
  dipartimento varchar(45),
  azienda varchar(30),
  primary key (username),
  unique(username)
  );
  
  
DROP TABLE IF EXISTS tirocinio;
CREATE TABLE IF NOT EXISTS tirocinio(
 codiceID int(25) not null auto_increment,
 rif_utente varchar(15) not null,
 rif_TA varchar(15) not null,
 rif_TE varchar(15) not null,
 azienda varchar(21) not NULL,
 data_inizio date not null,
 data_fine date not null,
 luogo varchar(26) not null,
 tematica varchar(51) not null,
 descrizione varchar(151) not null,
 primary key (codiceID),
 foreign key(rif_utente) references utente(username)
 
  );
  
  
  
DROP TABLE IF EXISTS documento;
CREATE TABLE IF NOT EXISTS documento(
 codiceID int(25) not null,
 nome varchar(20) not NULL,
 rif_utente varchar(15) not null,
 rif_tirocinio int(15) not null,
 primary key (codiceID),
 foreign key(rif_utente) references utente(username),
 foreign key(rif_tirocinio) references tirocinio(codiceID)
  );  
  
  
DROP TABLE IF EXISTS firma;
CREATE TABLE IF NOT EXISTS firma(
rif_utente varchar(15) not null,
rif_documento int(25) not null,
foreign key(rif_utente) references utente(username),
foreign key(rif_documento) references documento(codiceID)
);
  
/*STUDENTI*/  
INSERT INTO utente VALUES ('r.napo12', 'ciao', 'r.napo1@studenti.unisa.it', 'studente', 'Rita', 'Napo', '1996-05-27', '2009/2010', 102, 'Unisa', 'Matematica', '');
INSERT INTO utente VALUES ('m.pelu2', 'mpeluso', 'm.pelu2@studenti.unisa.it', 'studente', 'Maurizio', 'Peluso', '1994-09-22', '2009/2010', 110, 'Unisa', 'Matematica', '');
INSERT INTO utente VALUES ('responsabile', 'ciao', 'resp@studenti.unisa.it', 'responsabileAzienda', 'Rosa', 'Peluso', '1996-05-27', '', 0,  '', '', 'Unicornilandia');

/*TIROCINIO*/
INSERT INTO tirocinio VALUES (01 , 'responsabile', 'rif_TA', 'rif_TE','Sony', '2017-12-12', '2017-03-03', 'Napoli', 'Basi dati', 'non lo so cosa devo scrivere. questa è una prova!');
INSERT INTO tirocinio VALUES (02 , 'responsabile', 'rif_TA','rif_TE','Pony', '2017-12-12', '2017-03-03', 'Napoli', 'Sicurezza pony', 'non lo so cosa devo scrivere. questa è una prova!');

SELECT * FROM utente;

SELECT username FROM utente WHERE username ='r.napo12' AND password = 'ciao';
/**/ 
select * from tirocinio;
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