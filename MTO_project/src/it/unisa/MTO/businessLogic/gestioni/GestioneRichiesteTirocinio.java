package it.unisa.MTO.businessLogic.gestioni;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import it.unisa.MTO.common.Tirocinio;
import it.unisa.MTO.storage.DAO.GestioneRichiesteTirocinioDAO;
import it.unisa.MTO.storage.connection.ConnessioneException;

public class GestioneRichiesteTirocinio {

	public GestioneRichiesteTirocinio(){}

	public ArrayList<Tirocinio> visualizzaLista(String utenteUsername){
		GestioneRichiesteTirocinioDAO grtDAO;
		ArrayList<Tirocinio> lista = new ArrayList<Tirocinio>();
		try {
			grtDAO = new GestioneRichiesteTirocinioDAO();
			lista = grtDAO.getList(utenteUsername );
		} catch (ConnessioneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	

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

	public boolean visualizzaRichiesta(OutputStream out, String utenteUsername, String nomeFile, Integer codiceTirocinio){
		GestioneRichiesteTirocinioDAO grtDAO;
		try {
			grtDAO = new GestioneRichiesteTirocinioDAO();
			InputStream in = grtDAO.getDocument(utenteUsername, nomeFile, codiceTirocinio);

			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			while ((bytesRead = in.read(buffer)) != 1) {
				out.write(buffer, 0, bytesRead);
			}

			in.close();
			out.close();
			
		} catch (ConnessioneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public void eliminaRichiesta(String aziendaUsername, String studenteUsername){
		GestioneRichiesteTirocinioDAO grtDAO;
		try {
			grtDAO = new GestioneRichiesteTirocinioDAO();
			
			
			
		} catch (ConnessioneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void firma(){}

	public void visualizzaStato(){}
}
