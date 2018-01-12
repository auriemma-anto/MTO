package it.unisa.MTO.storage.interfaces;

import java.io.InputStream;
import java.util.ArrayList;

import it.unisa.MTO.common.DocumentoRichiesta;
import it.unisa.MTO.common.Tirocinio;

public interface IGRichiestaTirocinioDAO {
	
	public boolean setDocument(DocumentoRichiesta documento);
	public InputStream getDocument(String utenteUsername, String nomeFile, Integer codiceTirocinio);
	public ArrayList<Tirocinio> getList(String utenteUsername);
	public boolean delDocument(String utenteUsername, String nomeFile, Integer codiceTirocinio);
	public boolean markDocument(String utenteUsername, String nomeFile, Integer codiceTirocinio);
	public boolean checkDocState(String utenteUsername);

}
