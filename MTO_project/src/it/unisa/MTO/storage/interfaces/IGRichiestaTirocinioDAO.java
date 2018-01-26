package it.unisa.MTO.storage.interfaces;

import java.util.ArrayList;

import it.unisa.MTO.common.*;

public interface IGRichiestaTirocinioDAO {
	
	public boolean setDocument(DocumentoRichiesta documento);
	public DocumentoRichiesta getDocument(DocumentoRichiesta doc);
	public ArrayList<DocumentoRichiesta> getList(Utente utente);
	public boolean markDocument(DocumentoRichiesta documento, Utente utente, boolean firma);
	public DocumentoRichiesta checkDocState(DocumentoRichiesta documento);

}