package it.unisa.MTO.storage.interfaces;

import java.io.InputStream;
import java.util.ArrayList;

import it.unisa.MTO.common.DocumentoRichiesta;
import it.unisa.MTO.common.Tirocinio;
import it.unisa.MTO.common.Utente;

public interface IGRichiestaTirocinioDAO {
	
	public boolean setDocument(DocumentoRichiesta documento);
	public InputStream getDocument(DocumentoRichiesta doc);
	public ArrayList<DocumentoRichiesta> getList(Tirocinio tirocinio);
	public boolean delDocument(String utenteUsername, String nomeFile, Integer codiceTirocinio);
	public boolean markDocument(DocumentoRichiesta documento, Utente utente, boolean firma);
	public boolean checkDocState(String utenteUsername);

}
