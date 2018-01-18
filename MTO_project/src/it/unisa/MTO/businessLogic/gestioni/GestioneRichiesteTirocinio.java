package it.unisa.MTO.businessLogic.gestioni;

import java.io.InputStream;

import it.unisa.MTO.storage.DAO.GestioneRichiesteTirocinioDAO;
import it.unisa.MTO.storage.connection.ConnessioneException;

public class GestioneRichiesteTirocinio {
	
	public GestioneRichiesteTirocinio(){}
	
	public void visualizzaLista(){}
	
	public boolean aggiungiRichiesta(String utenteUsername, String nomeFile, Integer codiceTirocinio, InputStream file){
		GestioneRichiesteTirocinioDAO grtDAO;
		try {
			grtDAO = new GestioneRichiesteTirocinioDAO();
			return grtDAO.setDocument(utenteUsername, nomeFile, codiceTirocinio, file);
		} catch (ConnessioneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void visualizzaRichiesta(){}
	
	public void eliminaRichiesta(){}
	
	public void firma(){}
	
	public void visualizzaStato(){}
}
