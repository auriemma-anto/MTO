package it.unisa.MTO.storage.interfaces;

import it.unisa.MTO.common.Utente;

public interface IAccountDAO {

	public boolean checkUtente(String username);
	public boolean login(String username, String password);
	public boolean registrazione(Utente utente);
	
}
