package it.unisa.MTO.storage.interfaces;

import java.util.ArrayList;

import it.unisa.MTO.common.*;

public interface IGRichiestaTirocinioDAO {
	
	public boolean setDocument(DocumentoRichiesta documento);
	public DocumentoRichiesta getDocument(DocumentoRichiesta doc);
	public ArrayList<DocumentoRichiesta> getList(Tirocinio tirocinio, Utente studente);
	public boolean delDocument(String utenteUsername, String nomeFile, Integer codiceTirocinio);
	public boolean markDocument(DocumentoRichiesta documento, Utente utente, boolean firma);
	public DocumentoRichiesta checkDocState(DocumentoRichiesta documento);

}


//select * from documento where AND (NOT exists (SELECT rif_documento, rif_utente from firma))