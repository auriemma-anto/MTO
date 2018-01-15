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
	public ArrayList<DocumentoRichiesta> listaDomandeRichiesta(Tirocinio tirocinio, Utente studente){
		return gestioneRichiesteTirocinio.visualizzaLista(tirocinio, studente);
	}
	
	public boolean getDomandaRichiesta(DocumentoRichiesta doc, OutputStream outputStream){
		return gestioneRichiesteTirocinio.visualizzaRichiesta(doc, outputStream);
	}
	
	public boolean aggiungiDomandaRichiesta(DocumentoRichiesta documento){
		return gestioneRichiesteTirocinio.aggiungiRichiesta(documento);
	}
	
	public void eliminaDomandaRichiesta(){
		gestioneRichiesteTirocinio.eliminaRichiesta(null, null);
	}
	
	public boolean firmaDomandaRichiesta(DocumentoRichiesta documento, Utente utente, boolean firma){
		return gestioneRichiesteTirocinio.firma(documento, utente, firma);
	}
	
	public DocumentoRichiesta statoDomandaRichiesta(DocumentoRichiesta documento){
		return gestioneRichiesteTirocinio.visualizzaStato(documento);
	}
	
}
