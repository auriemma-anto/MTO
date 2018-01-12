package it.unisa.MTO.businessLogic;

import java.io.InputStream;
import java.text.ParseException;

import it.unisa.MTO.businessLogic.gestioni.*;
import it.unisa.MTO.common.Utente;

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
	
	public boolean registrazione(Utente utente) throws ParseException{
		return gestioneAccount.registrazione(utente);
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
