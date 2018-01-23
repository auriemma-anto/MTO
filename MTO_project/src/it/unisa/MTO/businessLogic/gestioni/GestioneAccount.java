package it.unisa.MTO.businessLogic.gestioni;

import it.unisa.MTO.common.Utente;
import it.unisa.MTO.storage.DAO.AccountDAO;
import it.unisa.MTO.storage.connection.*;
import it.unisa.MTO.storage.interfaces.IAccountDAO;

public class GestioneAccount {
	
	public GestioneAccount(){
		
	}
	
	/**
	 * Metodo che controlla se l'username e la password sono giusti
	 * @param username username dell'utente
	 * @param password password dell'utente
	 * @return <b>true</b> se username e password corrispondono con quelle presenti nel db, <b>false</b> altrimenti
	 * @throws ConnessioneException
	 */
	public boolean login(String username, String password) throws ConnessioneException{
		IAccountDAO connection = new AccountDAO();
		return connection.login(username, password);
	}
	
	/**
	 * Metodo che restituisce il tipo di utente
	 * @param username username dell'utente
	 * @param password password dell'utente
	 * @return restituisce il tipo di utente
	 * @throws ConnessioneException
	 */
	public String cercaTipo(String username, String password) throws ConnessioneException {
		IAccountDAO connection = new AccountDAO();
		return connection.trovaTipo(username, password);
	}
	
	/**
	 * Questo metodo registra un utente nel db
	 * @param utente utente da registrare ({@link Utente})
	 * @return <b>true</b> se la registrazione è avvenuta con successo, <b>false</b> altrimenti
	 * @throws ConnessioneException
	 */
	public boolean registrazione(Utente utente) throws ConnessioneException{
		IAccountDAO connection = new AccountDAO();
		
		if(connection.checkUtente(utente.getUsername()))
			return false;
		return connection.registrazione(utente);
	}
}
