package it.unisa.MTO.storage.DAO;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.MTO.common.DocumentoRichiesta;
import it.unisa.MTO.common.Tirocinio;
import it.unisa.MTO.common.Utente;
import it.unisa.MTO.storage.connection.AccessoDB;
import it.unisa.MTO.storage.connection.ConnessioneException;
import it.unisa.MTO.storage.interfaces.IGRichiestaTirocinioDAO;

public class GestioneRichiesteTirocinioDAO implements IGRichiestaTirocinioDAO{

	private AccessoDB db;

	public GestioneRichiesteTirocinioDAO() throws ConnessioneException {
		db = new AccessoDB();
	}

	public boolean setDocument(DocumentoRichiesta documento){
		
		Connection conn = db.getConnessione();
		
		Utente studente = documento.getStudente();
		String username = studente.getUsername();
		
		Tirocinio tirocinio = documento.getTirocinio();
		int codiceTir = tirocinio.getCodiceID();
		
		String nomeFile = documento.getNome();
		InputStream file = documento.getFile();
		
		System.out.println(""+username);
		System.out.println(""+codiceTir);
		System.out.println(""+file);
		
		String query = "INSERT INTO documento (nome, rif_utente, rif_tirocinio, file) VALUES (?,?,?,?);";

		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, nomeFile);
			statement.setString(2, username);
			statement.setInt(3, codiceTir);
	
			if (file != null) {
				// Inserisce l'inputStream per l'upload dei file nella colonna blob
				statement.setBlob(4, file);
			}

			System.out.println(""+statement);
			
			statement.executeUpdate();
			
			System.out.println("Update fatta");
			
			return true;

		} catch (SQLException ex) {
			if (conn != null) {
				// closes the database connection
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public InputStream getDocument(String utenteUsername, String nomeFile, Integer codiceTirocinio) {
		// TODO Auto-generated method stub
		InputStream inputStream = null;
		boolean st = false;
		Connection conn = db.getConnessione();
		String query = "SELECT * FROM Documento WHERE utenteUsername=? AND nome =? AND tirocinioCodiceID=?" ;

		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, utenteUsername);
			statement.setString(2, nomeFile);
			statement.setInt(3, codiceTirocinio);

			
			ResultSet res = statement.executeQuery(query);
			st = res.next();
			
			if(st) {
				Blob blob = res.getBlob("file");
				inputStream = blob.getBinaryStream();
			}

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
		return inputStream;

	}

	@Override
	public ArrayList<Tirocinio> getList(String utenteUsername) {
		// TODO Auto-generated method stub
		
		
		Connection conn = db.getConnessione();
		ArrayList<Tirocinio> lista = new ArrayList<Tirocinio>();
		String query = "SELECT * FROM Tirocinio WHERE rif_utente=? " ;

		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, utenteUsername);

			
			ResultSet res = statement.executeQuery(query);

			while(res.next()) {
				Tirocinio t = new Tirocinio();
				t.setAzienda(res.getString("azienda"));
				t.setCodiceID(res.getInt("codiceID"));
				t.setDataFine(res.getDate("data_fine"));
				t.setDataInizio(res.getDate("data_inizio"));
				t.setDescizione(res.getString("descrizione"));
				t.setLuogo(res.getString("luogo"));
				t.setTematica(res.getString("tematica"));
				lista.add(t);
			}
			

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
		return lista;
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

