
package it.unisa.MTO.businessLogic;

import java.io.OutputStream;
import java.util.ArrayList;

import it.unisa.MTO.businessLogic.gestioni.*;
import it.unisa.MTO.common.*;

public class Facade {
	private GestioneAccount gestioneAccount;
	private GestioneTirocinio gestioneTirocinio;
	private GestioneRichiesteTirocinio gestioneRichiesteTirocinio;
	
	public Facade(){
		gestioneAccount = new GestioneAccount();
		gestioneTirocinio = new GestioneTirocinio();
		gestioneRichiesteTirocinio = new GestioneRichiesteTirocinio();
	}
	//----------GESTIONE ACCOUNT
	/**
	 * Metodo che controlla se l'username e la password sono giusti
	 * @param username username dell'utente
	 * @param password password dell'utente
	 * @return <b>true</b> se username e password corrispondono con quelle presenti nel db, <b>false</b> altrimenti
	 * @throws ConnessioneException
	 */
	public boolean login(String username, String password) throws ConnessioneException{
		return gestioneAccount.login(username, password);
	}
	
	/**
	 * Metodo che restituisce il tipo di utente
	 * @param username username dell'utente
	 * @param password password dell'utente
	 * @return restituisce il tipo di utente
	 * @throws ConnessioneException
	 */
	public String getTipo(String username, String password) throws ConnessioneException {
		return gestioneAccount.cercaTipo(username, password);
	}
	
	/**
	 * Questo metodo registra un utente nel db
	 * @param utente utente da registrare ({@link Utente})
	 * @return <b>true</b> se la registrazione è avvenuta con successo, <b>false</b> altrimenti
	 * @throws ConnessioneException
	 */
	public boolean registrazione(Utente utente) throws ConnessioneException{
		return gestioneAccount.registrazione(utente);
	}
	
	//----------GESTIONE TIROCINIO
	
	/**
	 * Metodo che modifica un <b>Tirocinio</b> nel <b>DataBase</b>
	 * @param tirocinio {@link Tirocinio} da modificare
	 * @return <b>true</b> in caso di avvenuta modifica, <b>false</b> altrimenti
	 * @throws ConnessioneException
	 */
	public boolean modificaTirocinio(Tirocinio tirocinio) throws ConnessioneException{
		return gestioneTirocinio.modificaTirocinio(tirocinio);
	}
	
	/**
	 * Metodo che aggiunge un <b>Tirocinio</b> nel <b>DataBase</b>
	 * @param tirocinio {@link Tirocinio} da aggiungere
	 * @return <b>true</b> in caso di avvenuta aggiunta, <b>false</b> altrimenti
	 * @throws ConnessioneException
	 */
	public boolean aggiungiTirocinio(Tirocinio tirocinio) throws ConnessioneException{
		return gestioneTirocinio.aggiungiTirocinio(tirocinio);
	}
	
	/**
	 * Metodo che elimina un <b>Tirocinio</b> nel <b>DataBase</b> dato il suo id
	 * @param id del tirocinio
	 * @return <b>true</b> in caso di avvenuta cancellazione, <b>false</b> altrimenti
	 * @throws ConnessioneException
	 */
	public boolean eliminaTirocinio(int id) throws ConnessioneException{
		return gestioneTirocinio.eliminaTirocinio(id);
	}
	
	/**
	 * Restituisce la lista completa dei <b>Tirocini</b> presente nel <b>Database</b>
	 * @return restituisce un {@link java.util.ArrayList} di {@link Tirocinio}
	 * @throws ConnessioneException
	 */
	public ArrayList<Tirocinio> listaTirocinio() throws ConnessioneException{
		return gestioneTirocinio.listaTirocini();
	}
	
	/**
	 * Restituisce la lista filtrata dei <b>Tirocini</b> presente nel <b>Database</b>
	 * @param type tipo di filtro da applicare alla ricerca ({@link ParamType})
	 * @param param parametro
	 * @return restituisce un {@link java.util.ArrayList} di {@link Tirocinio}
	 * @throws ConnessioneException
	 */
	public ArrayList<Tirocinio> ricercaTirociniPerParametri(ParamType type, String param) throws ConnessioneException{
		return gestioneTirocinio.ricerchePerParametri(type, param);
	}
	
	/**
	 * Metodo che restituisce un {@link Tirocinio} dato il suo codice id
	 * @param id del tirocinio
	 * @return restituisce un {@link Tirocinio}
	 * @throws ConnessioneException
	 */
	public Tirocinio getTirocinio(int id) throws ConnessioneException{
		return gestioneTirocinio.getTirocinio(id);
	}
	
	//----------GESTIONE DOMANDE RICHIESTA
	
	/**
	 * Metodo che richiama la funzione della classe GestioneRichiesteTirocinio.java per ottenere la lista dei progetti formativi passandogli i parametri ricevuti dalla Servlet
	 * @param tirocinio è un oggetto che contiene le informazioni relative ad esso necessarie per interfacciarsi con il database
	 * @param studente è un oggetto che contiene le informazioni relative ad esso necessarie per interfacciarsi con il database
	 * @return ArrayList di documentoRichiesta
	 */
	
	public ArrayList<DocumentoRichiesta> listaDomandeRichiesta(Tirocinio tirocinio, Utente studente){
		return gestioneRichiesteTirocinio.visualizzaLista(tirocinio, studente);
	}
	
	/**
	 * Metodo che richiama la funzione della classe GestioneRichiesteTirocinio.java per l'aggiunta di un nuovo progetto formativo passandogli i parametri ricevuti dalla Servlet
	 * @param documento è un oggetto che contiene le informazioni relative ad esso necessarie per interfacciarsi con il database
	 * @return un booleano di corretto funzionamento del metodo
	 */
	
	public boolean getDomandaRichiesta(DocumentoRichiesta doc, OutputStream outputStream){
		return gestioneRichiesteTirocinio.visualizzaRichiesta(doc, outputStream);
	}
	
	/**
	 * Metodo che richiama la funzione della classe GestioneRichiesteTirocinio.java per il download di un progetto formativo, ricevendo da quest'ultimo il file come inpuStream necessario per ottenere i byte da mandare sull'outputstream
	 * @param documento è un oggetto che contiene le informazioni relative ad esso necessarie per interfacciarsi con il database
	 * @param outputStream è l'outputStream con cui inviare i byte del file
	 * @return un booleano di corretto funzionamento del metodo
	 */
	
	public boolean aggiungiDomandaRichiesta(DocumentoRichiesta documento){
		return gestioneRichiesteTirocinio.aggiungiRichiesta(documento);
	}
	
	/**
	 * Metodo che richiama la funzione della classe GestioneRichiesteTirocinio.java per l'aggiunta di una firma ad un determinato progetto formativo
	 * @param documento è un oggetto che contiene le informazioni relative ad esso necessarie per interfacciarsi con il database
	 * @param utente è un oggetto che contiene le informazioni relative ad esso necessarie per interfacciarsi con il database
	 * @param firma è un boolean che rappresenta se il documento è stato accettato o rifiutato
	 * @return un booleano di corretto funzionamento del metodo
	 */

	public boolean firmaDomandaRichiesta(DocumentoRichiesta documento, Utente utente, boolean firma){
		return gestioneRichiesteTirocinio.firma(documento, utente, firma);
	}
	
	/**
	 * Metodo che richiama la funzione della classe GestioneRichiesteTirocinio.java per la visualizzazione dello stato di avanzamento di un progetto formativo
	 * @param documento è un oggetto che contiene le informazioni relative ad esso necessarie per interfacciarsi con il database
	 * @return il documento passato come parametro con l'attributo firma completo
	 * @throws ConnessioneException viene lanciata per errori di connessione con il database
	 */
	
	public DocumentoRichiesta statoDomandaRichiesta(DocumentoRichiesta documento){
		return gestioneRichiesteTirocinio.visualizzaStato(documento);
	}
	
}

