package it.unisa.MTO.businessLogic.gestioni;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import it.unisa.MTO.common.DocumentoRichiesta;
import it.unisa.MTO.common.Tirocinio;
import it.unisa.MTO.common.Utente;
import it.unisa.MTO.storage.DAO.GestioneRichiesteTirocinioDAO;
import it.unisa.MTO.storage.connection.ConnessioneException;
import it.unisa.MTO.storage.interfaces.IGRichiestaTirocinioDAO;

public class GestioneRichiesteTirocinio {

	public GestioneRichiesteTirocinio(){}

	public ArrayList<DocumentoRichiesta> visualizzaLista(Tirocinio tirocinio){
		IGRichiestaTirocinioDAO grtDAO;
		try {
			grtDAO = new GestioneRichiesteTirocinioDAO();
			return grtDAO.getList(tirocinio);
		} catch (ConnessioneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	public boolean aggiungiRichiesta(DocumentoRichiesta documento){
		IGRichiestaTirocinioDAO grtDAO;
		try {
			grtDAO = new GestioneRichiesteTirocinioDAO();
			return grtDAO.setDocument(documento);
		} catch (ConnessioneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean visualizzaRichiesta(DocumentoRichiesta doc, OutputStream out){
		IGRichiestaTirocinioDAO grtDAO;
		try {
			grtDAO = new GestioneRichiesteTirocinioDAO();
			InputStream in = grtDAO.getDocument(doc);

			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			while ((bytesRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, bytesRead);
			}

			out.close();
			in.close();

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

	public boolean firma(DocumentoRichiesta documento, Utente utente, boolean firma){
		IGRichiestaTirocinioDAO grtDAO;
		try{
			grtDAO = new GestioneRichiesteTirocinioDAO();
			return grtDAO.markDocument(documento, utente, firma);
		}catch (ConnessioneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public void visualizzaStato(){}
}
