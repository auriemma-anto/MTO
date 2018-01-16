package it.unisa.MTO.businessLogic.gestioni;

import it.unisa.MTO.common.Utente;
import it.unisa.MTO.storage.DAO.AccountDAO;
import it.unisa.MTO.storage.connection.*;
import it.unisa.MTO.storage.interfaces.IAccountDAO;

public class GestioneAccount {
	
	public GestioneAccount(){
		
	}
	
	public boolean login(String username, String password) throws ConnessioneException{
		IAccountDAO connection = new AccountDAO();
		return connection.login(username, password);
	}
	
	public void logout(){}
	
	public boolean registrazione(Utente utente) throws ConnessioneException{
		IAccountDAO connection = new AccountDAO();
		
		if(connection.checkUtente(utente.getUsername()))
			return false;
		return connection.registrazione(utente);
	}
}
