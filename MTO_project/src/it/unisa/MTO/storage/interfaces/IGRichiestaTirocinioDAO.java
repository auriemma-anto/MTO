package it.unisa.MTO.storage.interfaces;

import java.io.InputStream;

public interface IGRichiestaTirocinioDAO {
	
	public boolean setDocument(String utenteUsername, String nomeFile, Integer codiceTirocinio, InputStream file);
	public boolean getDocument(String utenteUsername, String nomeFile, Integer codiceTirocinio);
	public boolean getList(String utenteUsername);
	public boolean delDocument(String utenteUsername, String nomeFile, Integer codiceTirocinio);
	public boolean markDocument(String utenteUsername, String nomeFile, Integer codiceTirocinio);
	public boolean checkDocState(String utenteUsername);

}
