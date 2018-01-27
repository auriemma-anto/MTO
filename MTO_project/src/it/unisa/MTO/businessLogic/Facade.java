package it.unisa.MTO.businessLogic;

import java.io.InputStream;
import java.util.ArrayList;

import it.unisa.MTO.businessLogic.gestioni.*;
import it.unisa.MTO.common.ParamType;
import it.unisa.MTO.common.Tirocinio;
import it.unisa.MTO.common.Utente;
import it.unisa.MTO.storage.connection.ConnessioneException;

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
	public void listaDomandeRichiesta(){
		gestioneRichiesteTirocinio.visualizzaLista();
	}
	
	public void getDomandaRichiesta(){
		gestioneRichiesteTirocinio.visualizzaRichiesta();
	}
	
	public boolean aggiungiDomandaRichiesta(String utenteUsername, String nomeFile, Integer codiceTirocinio, InputStream file){
		return gestioneRichiesteTirocinio.aggiungiRichiesta(utenteUsername, nomeFile, codiceTirocinio, file);
	}
	
	public void eliminaDomandaRichiesta(){
		gestioneRichiesteTirocinio.eliminaRichiesta();
	}
	
	public void firmaDomandaRichiesta(){
		gestioneRichiesteTirocinio.firma();
	}
	
	public void statoDomandaRichiesta(){
		gestioneRichiesteTirocinio.visualizzaStato();
	}
	
}
