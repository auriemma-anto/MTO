package it.unisa.MTO.storage.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.unisa.MTO.common.Utente;
import it.unisa.MTO.storage.connection.AccessoDB;
import it.unisa.MTO.storage.connection.ConnessioneException;
import it.unisa.MTO.storage.interfaces.IAccountDAO;

/**
 * Classe che gestione la connessione con il database relativamente alla tabella 'utente' 
 * @author Maurizio Peluso
 * @author Maddalena Napolitano
 *
 */
public class AccountDAO implements IAccountDAO {

	private AccessoDB db;
	private Connection conn;
	
	public AccountDAO() throws ConnessioneException{
		db = new AccessoDB();
		conn = db.getConnessione();
	}
	
	/**
	 * Metodo che controlla se l'username e la password sono giusti
	 * @param username username dell'utente
	 * @param password password dell'utente
	 * @return 'true' se username e password corrispondono con quelle presenti nel db, 'false' altrimenti
	 */
	@Override
	public boolean login(String username, String password) {
		boolean toReturn = false;
		String queryControllo ="SELECT username FROM utente WHERE username ='"+ username + "' AND password = '" + password + "';";
		
		try {
			PreparedStatement pStatement = conn.prepareStatement(queryControllo);
			ResultSet rs = pStatement.executeQuery(queryControllo);
			toReturn = rs.next();
			rs.close();
			pStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return toReturn;
	}
	
	public String trovaTipo(String username, String password) {
		String queryTipo ="SELECT tipo FROM utente WHERE username ='"+ username + "' AND password = '" + password + "';";
		
		String tipo="";
		
		try {
			PreparedStatement pStatement = conn.prepareStatement(queryTipo);
			ResultSet rs = pStatement.executeQuery(queryTipo);
			rs.next();
			tipo = rs.getString("tipo");
			rs.close();
			pStatement.close();
			
			return tipo;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
				return null;
	}


	/**
	 * Questo metodo registra un utente nel db
	 * @param utente utente da registrare
	 * @return 'true' se la registrazione è avvenuta con successo, 'false' altrimenti
	 */
	@Override
	public boolean registrazione(Utente utente) {
		boolean toReturn = false;
		String query = "INSERT INTO utente (username, password, email, tipo, nome, cognome, data_nascita, annoImmatricolazione, CFU, universita, dipartimento, azienda) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement pStatement = conn.prepareStatement(query);
			pStatement.setString(1, utente.getUsername());
			pStatement.setString(2, utente.getPassword());
			pStatement.setString(3, utente.getEmail());
			pStatement.setString(4, utente.getTipo().toString());
			pStatement.setString(5, utente.getNome());
			pStatement.setString(6, utente.getCognome());	
			pStatement.setString(7, utente.getDataNascita());
			pStatement.setString(8, utente.getAnnoImmatricolazione());
			pStatement.setInt(9, utente.getCfu());
			pStatement.setString(10, utente.getUniversita());
			pStatement.setString(11, utente.getDipartimento());
			pStatement.setString(12, utente.getAzienda());
			int res = pStatement.executeUpdate();
			pStatement.close();
			
			toReturn = res > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return toReturn;
	}

	
	/**
	 * Metodo che controlla se l'username dato in input è già presente nel db
	 * @param username username dell'utente
	 * @return 'true' se username è già presente nel db, 'false' altrimenti
	 */
	@Override
	public boolean checkUtente(String username) {
		boolean toReturn = false;
		String queryControllo ="SELECT username FROM utente WHERE username ='"+ username + "';";
		
		try {
			PreparedStatement pStatement = conn.prepareStatement(queryControllo);
			ResultSet rs = pStatement.executeQuery(queryControllo);
			toReturn = rs.next();
			rs.close();
			pStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return toReturn;
	}


	
}
