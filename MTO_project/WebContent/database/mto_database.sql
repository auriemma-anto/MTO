DROP DATABASE IF EXISTS mto_database;
CREATE DATABASE mto_database;
USE mto_database;

DROP TABLE IF EXISTS Utente;
CREATE TABLE IF NOT EXISTS Utente
(

	username	  			varchar(15),
	password				varchar(20) not null,
    email					varchar(50) not null,
	tipo					varchar(40) not null,
    nome					varchar(20) not null,
    cognome					varchar(20) not null,
    dataNascita				date,
    annoImmatricolazione	varchar(9),
    cfu						integer(10),
    università				varchar(50),
    dipartimento			varchar(25),
    azienda					varchar(30),
    
	primary key(username)

);

DROP TABLE IF EXISTS Tirocinio;
CREATE TABLE IF NOT EXISTS Tirocinio
(

	codiceID				integer(15) auto_increment,
    utenteUsername 			varchar(15) not null,
    azienda					varchar(30) not null,
    dataInizio				date not null,
    dataFine				date not null,
    luogo					varchar(20) not null,
    tematica				varchar(100) not null,
    descrizione				varchar(500) not null,
    
    primary key(codiceID),
    foreign key (utenteUsername) references Utente(username)
    
);

DROP TABLE IF EXISTS Documento;
CREATE TABLE IF NOT EXISTS Documento
(

	codiceID				integer(25),
    utenteUsername 			varchar(15) not null,
    nome					varchar(20) not null,
    tirocinioCodiceID		integer(15) not null,
    file					mediumblob,
    
    primary key(codiceID),
    foreign key (tirocinioCodiceID) references Tirocinio(codiceID),
    foreign key (utenteUsername) references Utente(username)

);

DROP TABLE IF EXISTS Firma;
CREATE TABLE IF NOT EXISTS Firma
(

	documentoCodiceID		integer(25) not null,
    utenteUsername 			varchar(15) not null,
    
    foreign key (documentoCodiceID) references Documento(codiceID),
    foreign key (utenteUsername) references Utente(username)
);

/* Popolamento database */

/* UTENTE */ 
INSERT INTO Utente VALUES('uffstage.unisa', 'unisaTirocini', 'a.auriemma@unisa.it', 'Ufficio Stage & Tirocini', 'Antonio', 'Ceruso', '1985-12-21', null, null, 'Università degli Studi di Salerno', 'Informatica', null);

INSERT INTO Utente VALUES('c.desantis', 'carlo123', 'c.desantis2@studenti.unisa.it', 'Studente', 'Carlo', 'De Santis', '1994-11-19', '2015/2016', 130, 'Università degli Studi di Salerno', 'Informatica', null);

INSERT INTO Utente VALUES('s.latorre', 'salvatore234', 'slatorre@unisa.it', 'Tutor Interno', 'Salvatore', 'La Torre', '1954-02-09', null, null, 'Università degli Studi di Salerno', 'Informatica', null);

INSERT INTO Utente VALUES('ericsson.resp', 'a12b34c56', 'g.fortunato@ericsson.it', 'Responsabile Azienda', 'Giovanni', 'Fortunato', '1974-10-10', null, null, null, null, 'Ericsson Pagani');

INSERT INTO Utente VALUES('ericsson.tut', 'x98y76z54', 'a.demartino@ericsson.it', 'Tutor Esterno', 'Alessandra', 'De Martino', '1972-10-29', null, null, null, null, 'Ericsson Pagani');

/* TIROCINIO */

ALTER TABLE Tirocinio AUTO_INCREMENT = 0;
INSERT INTO Tirocinio VALUES (0, (SELECT username FROM Utente WHERE azienda='Ericsson Pagani' && tipo='Responsabile Azienda'), 
	'Ericsson Pagani', '2018-07-06', '2018-08-06', 'Pagani', 'Analisi statica del codice con tecniche sviluppate nell’ambito dei metodi formali',
	'L’obiettivo del tirocinio è di estrarre benchmarks, adattare tool di verifica e sperimentare le tecniche di verifica automatica 
    sul codice sviluppato da Ericsson. Individuare errori (bug) e criticità nel codice sviluppati da Ericsson. ');