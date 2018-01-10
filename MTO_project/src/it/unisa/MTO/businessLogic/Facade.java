package it.unisa.MTO.businessLogic;

import it.unisa.MTO.businessLogic.gestioni.*;

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
	public void listaDomandeRichiesta(){
		gestioneRichiesteTirocinio.visualizzaLista();
	}
	
	public void getDomandaRichiesta(){
		gestioneRichiesteTirocinio.visualizzaRichiesta();
	}
	
	public void aggiungiDomandaRichiesta(){
		gestioneRichiesteTirocinio.aggiungiRichiesta();
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
