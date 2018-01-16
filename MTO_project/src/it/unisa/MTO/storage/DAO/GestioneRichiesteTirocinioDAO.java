package it.unisa.MTO.storage.DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.unisa.MTO.storage.connection.AccessoDB;
import it.unisa.MTO.storage.connection.ConnessioneException;
import it.unisa.MTO.storage.interfaces.IGRichiestaTirocinioDAO;

public class GestioneRichiesteTirocinioDAO implements IGRichiestaTirocinioDAO{

	private AccessoDB db;

	public GestioneRichiesteTirocinioDAO() throws ConnessioneException {
		db = new AccessoDB();
	}

	public boolean setDocument(String utenteUsername, String nomeFile, Integer codiceTirocinio, InputStream file){
		boolean st = false;
		Connection conn = db.getConnessione();
		String query = "INSERT INTO documento (utenteUsername, nome, "
				+ "tirocinioCodiceID, file) values (?, ?, ?, ?)";

		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, utenteUsername);
			statement.setString(2, nomeFile);
			statement.setInt(3, codiceTirocinio);

			if (file != null) {
				// Inserisce l'inputStream per l'upload dei file nella colonna blob
				statement.setBlob(4, file);
			}

			ResultSet res = statement.executeQuery(query);
			st = res.next();

		} catch (SQLException ex) {
			if (conn != null) {
				// closes the database connection
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return st;
	}

	@Override
	public boolean getDocument(String utenteUsername, String nomeFile, Integer codiceTirocinio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getList(String utenteUsername) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delDocument(String utenteUsername, String nomeFile, Integer codiceTirocinio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean markDocument(String utenteUsername, String nomeFile, Integer codiceTirocinio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkDocState(String utenteUsername) {
		// TODO Auto-generated method stub
		return false;
	}
}

