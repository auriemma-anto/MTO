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

/**
 * Tale classe descrive le operazioni inerenti alla gestione delle richieste di tirocinio, richiamando le funzioni del DAO.
 */

public class GestioneRichiesteTirocinio {

	public GestioneRichiesteTirocinio(){}

	/**
	 * Tale metodo richiama una funzione del DAO per ottenere la lista dei progetti formativi presentati passandogli i parametri ricevuti
	 * @param tirocinio è un oggetto che contiene le informazioni relative ad esso necessarie per interfacciarsi con il database
	 * @param studente  è un oggetto che contiene le informazioni relative ad esso necessarie per interfacciarsi con il database
	 * @throws ConnessioneException viene lanciata per errori di connessione con il database
	 * @return ArrayList di documentoRichiesta
	 * 
	 */
	
	public ArrayList<DocumentoRichiesta> visualizzaLista(Tirocinio tirocinio, Utente studente){
		IGRichiestaTirocinioDAO grtDAO;
		try {
			grtDAO = new GestioneRichiesteTirocinioDAO();
			return grtDAO.getList(tirocinio, studente);
		} catch (ConnessioneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Tale metodo richiama una funzione del DAO per l'aggiunta di un nuovo progetto formativo passandogli i parametri ricevuti
	 * @param documento è un oggetto che contiene le informazioni relative ad esso necessarie per interfacciarsi con il database
	 * @return un booleano di corretto funzionamento del metodo
	 * @throws ConnessioneException viene lanciata per errori di connessione con il database
	 */

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
	
	/**
	 * Tale metodo richiama una funzione del DAO per il download di un progetto formativo, ricevendo da quest'ultimo il file come inpuStream necessario per ottenere i byte da mandare sull'outputstream
	 * @param documento è un oggetto che contiene le informazioni relative ad esso necessarie per interfacciarsi con il database
	 * @param outputStream è l'outputStream con cui inviare i byte del file
	 * @return un booleano di corretto funzionamento del metodo
	 * @throws ConnessioneException viene lanciata per errori di connessione con il database
	 * @throws IOException viene lanciata per errori di in/out
	 */

	public boolean visualizzaRichiesta(DocumentoRichiesta doc, OutputStream out){
		IGRichiestaTirocinioDAO grtDAO;
		try {
			grtDAO = new GestioneRichiesteTirocinioDAO();
			InputStream in = grtDAO.getDocument(doc).getFile();

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
	
	/**
	 * Tale metodo richiama una funzione del DAO per l'aggiunta di una firma ad un determinato progetto formativo
	 * @param documento è un oggetto che contiene le informazioni relative ad esso necessarie per interfacciarsi con il database
	 * @param utente è un oggetto che contiene le informazioni relative ad esso necessarie per interfacciarsi con il database
	 * @param firma è un boolean che rappresenta se il documento è stato accettato o rifiutato
	 * @return un booleano di corretto funzionamento del metodo
	 * @throws ConnessioneException viene lanciata per errori di connessione con il database
	 */

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

	/**
	 * Tale metodo richiama una funzione del DAO per la visualizzazione dello stato di avanzamento di un progetto formativo
	 * @param documento è un oggetto che contiene le informazioni relative ad esso necessarie per interfacciarsi con il database
	 * @return il documento passato come parametro con l'attributo firma completo
	 * @throws ConnessioneException viene lanciata per errori di connessione con il database
	 */
	
	public DocumentoRichiesta visualizzaStato(DocumentoRichiesta documento){
		IGRichiestaTirocinioDAO grtDAO;
		try{
			grtDAO = new GestioneRichiesteTirocinioDAO();
			return grtDAO.checkDocState(documento);
		}catch (ConnessioneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return documento;
		
	}
}

