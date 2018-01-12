package it.unisa.MTO.businessLogic.gestioni;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import it.unisa.MTO.common.DocumentoRichiesta;
import it.unisa.MTO.common.Tirocinio;
import it.unisa.MTO.storage.DAO.GestioneRichiesteTirocinioDAO;
import it.unisa.MTO.storage.connection.ConnessioneException;
import it.unisa.MTO.storage.interfaces.IGRichiestaTirocinioDAO;

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
		GestioneRichiesteTirocinioDAO grtDAO;
		try {
			grtDAO = new GestioneRichiesteTirocinioDAO();
			InputStream in = grtDAO.getDocument(doc);

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
