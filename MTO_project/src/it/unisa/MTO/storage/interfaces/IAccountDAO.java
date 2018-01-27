package it.unisa.MTO.storage.interfaces;

import it.unisa.MTO.common.Utente;

public interface IAccountDAO {

	/**
	 * Metodo che controlla se l'username dato in input è già presente nel db.
	 * @param username username dell'utente
	 * @return <b>true</b> se username è già presente nel db, <b>false</b> altrimenti
	 */
	public boolean checkUtente(String username);
	
	/**
	 * Metodo che controlla se l'username e la password sono giusti
	 * @param username username dell'utente
	 * @param password password dell'utente
	 * @return <b>true</b> se username e password corrispondono con quelle presenti nel db, <b>false</b> altrimenti
	 */
	public boolean login(String username, String password);
	
	/**
	 * Questo metodo registra un utente nel db
	 * @param utente utente da registrare ({@link Utente})
	 * @return <b>true</b> se la registrazione è avvenuta con successo, <b>false</b> altrimenti
	 */
	public boolean registrazione(Utente utente);
	
	/**
	 * Metodo che restituisce il tipo di utente
	 * @param username username dell'utente
	 * @param password password dell'utente
	 * @return restituisce il tipo di utente
	 */
	public String trovaTipo(String username, String password);
	
}
