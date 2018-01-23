package it.unisa.MTO.businessLogic;

import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;

import it.unisa.MTO.businessLogic.gestioni.*;
import it.unisa.MTO.common.ParamType;
import it.unisa.MTO.common.Tirocinio;
import it.unisa.MTO.common.Utente;
import it.unisa.MTO.storage.connection.ConnessioneException;
import it.unisa.MTO.storage.connection.exe.LoginFailedException;

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
	public boolean login(String username, String password) throws ConnessioneException{
		return gestioneAccount.login(username, password);
	}
	
	public String getTipo(String username, String password) throws ConnessioneException {
		return gestioneAccount.cercaTipo(username, password);
	}
	
		
	public boolean registrazione(Utente utente) throws ConnessioneException, ParseException {
		return gestioneAccount.registrazione(utente);
	}
	
	//----------GESTIONE TIROCINIO
	  public boolean modificaTirocinio(Tirocinio tirocinio) throws ConnessioneException{
	    return gestioneTirocinio.modificaTirocinio(tirocinio);
	  }
	  
	  public boolean aggiungiTirocinio(Tirocinio tirocinio) throws ConnessioneException{
	    return gestioneTirocinio.aggiungiTirocinio(tirocinio);
	  }
	  
	  public boolean eliminaTirocinio(int id) throws ConnessioneException{
	    return gestioneTirocinio.eliminaTirocinio(id);
	  }
	  
	  public ArrayList<Tirocinio> listaTirocinio() throws ConnessioneException{
	    return gestioneTirocinio.listaTirocini();
	  }
	  
	  public ArrayList<Tirocinio> ricercaTirociniPerParametri(ParamType type, String param) throws ConnessioneException{
	    return gestioneTirocinio.ricerchePerParametri(type, param);
	  }
	  
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
