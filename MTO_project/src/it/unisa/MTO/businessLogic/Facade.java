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
	public boolean login(String username, String password){
		return gestioneAccount.login(username, password);
	}
	
	public void logout(){
		gestioneAccount.logout();
	}
	
	public void registrazione(){
		gestioneAccount.registrazione();
	}
	
	//----------GESTIONE TIROCINIO
	public void modificaTirocinio(){
		gestioneTirocinio.modificaTirocinio();
	}
	
	public void aggiungiTirocinio(){
		gestioneTirocinio.aggiungiTirocinio();
	}
	
	public void eliminaTirocinio(){
		gestioneTirocinio.eliminaTirocinio();
	}
	
	public void listaTirocinio(){
		gestioneTirocinio.listaTirocini();
	}
	
	public void ricercaTirociniPerParametri(){
		gestioneTirocinio.ricerchePerParametri();
	}
	
	public void getTirocinio(){
		gestioneTirocinio.getTirocini();
	}
	
	//----------GESTIONE DOMANDE RICHIESTA
	
	/**
	 * Metodo che richiama la funzione della classe GestioneRichiesteTirocinio.java per ottenere la lista dei progetti formativi passandogli i parametri ricevuti dalla Servlet
	 * @param utente è un oggetto che contiene le informazioni relative ad esso necessarie per interfacciarsi con il database
	 * @return ArrayList di documentoRichiesta
	 */
	
	public ArrayList<DocumentoRichiesta> listaDomandeRichiesta(Utente utente){
		return gestioneRichiesteTirocinio.visualizzaLista(utente);
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
