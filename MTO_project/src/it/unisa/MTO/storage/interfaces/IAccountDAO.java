package it.unisa.MTO.storage.interfaces;

import java.text.ParseException;

import it.unisa.MTO.common.Utente;
import it.unisa.MTO.storage.connection.exe.LoginFailedException;

public interface IAccountDAO {

	public boolean checkUtente(String username);
	public boolean login(String username, String password);
	public boolean registrazione(Utente utente) throws ParseException;
	public String trovaTipo(String username, String password);
	
	
}
