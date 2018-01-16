package it.unisa.MTO.storage.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.unisa.MTO.common.Utente;
import it.unisa.MTO.storage.connection.AccessoDB;
import it.unisa.MTO.storage.connection.ConnessioneException;
import it.unisa.MTO.storage.interfaces.IAccountDAO;

public class AccountDAO implements IAccountDAO {

	private AccessoDB db;
	private Connection conn;
	
	public AccountDAO() throws ConnessioneException{
		db = new AccessoDB();
		conn = db.getConnessione();
	}
	
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

	@Override
	public boolean registrazione(Utente utente) {
		boolean toReturn = false;
		String query = "INSET INTO utente (username, password, email, tipo, nome, cognome, "
				+ "data_nascita, annoImmatricolazione, CFU, universita, dipartimento, azienda) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement pStatement = conn.prepareStatement(query);
			pStatement.setString(1, utente.getUsername());
			pStatement.setString(2, utente.getPassword());
			pStatement.setString(3, utente.getEmail());
			pStatement.setString(4, utente.getTipo().toString());
			pStatement.setString(5, utente.getNome());
			pStatement.setString(6, utente.getCognome());
			//data
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
