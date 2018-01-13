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
	public InputStream getDocument(DocumentoRichiesta doc) {
		// TODO Auto-generated method stub
		InputStream inputStream = null;
		Utente studente = doc.getStudente();
		String username = studente.getUsername();

		Tirocinio tirocinio = doc.getTirocinio();
		int codiceTir = tirocinio.getCodiceID();

		String nomeFile = doc.getNome();
		boolean st = false;
		Connection conn = db.getConnessione();
		String query = "SELECT * FROM documento WHERE nome = '"+nomeFile+"' AND rif_utente = '"+username+"' AND rif_tirocinio = "+codiceTir+";";

		try {
			PreparedStatement statement = conn.prepareStatement(query);

			System.out.println(""+statement);
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
			ex.printStackTrace();
		}
		return inputStream;
	}

	@Override
	public ArrayList<DocumentoRichiesta> getList(Tirocinio tirocinio) {
		// TODO Auto-generated method stub

		Connection conn = db.getConnessione();
		int codiceID = tirocinio.getCodiceID();
		ArrayList<DocumentoRichiesta> lista = new ArrayList<DocumentoRichiesta>();
		String query = "SELECT * FROM documento WHERE rif_tirocinio='"+codiceID+"';";

		try {
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet res = statement.executeQuery(query);

			while(res.next()) {
				DocumentoRichiesta doc = new DocumentoRichiesta();
				doc.setCodiceID(res.getInt("codiceID"));
				doc.setNome(res.getString("nome"));
				doc.setTirocinio(tirocinio);
				Utente st = new Utente();
				st.setUsername(res.getString("rif_utente"));
				doc.setStudente(st);
				lista.add(doc);
				System.out.println("DAO: "+doc.getCodiceID());
				System.out.println("DAO: "+doc.getNome());
				System.out.println("DAO: "+doc.getTirocinio().getCodiceID());
				System.out.println("DAO: "+doc.getStudente().getUsername());
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

			ex.printStackTrace();
		}
		return lista;
	}

	@Override
	public boolean delDocument(String utenteUsername, String nomeFile, Integer codiceTirocinio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean markDocument(DocumentoRichiesta documento, Utente utente, boolean firma) {

		Connection conn = db.getConnessione(); 
		String query = "INSERT INTO firma (rif_utente, rif_documento, valore) VALUES ('"+utente.getUsername()+"', '"+documento.getCodiceID()+"', "+firma+");";

		try{

			PreparedStatement statement = conn.prepareStatement(query);
			statement.executeUpdate();
			return true;

		}catch (SQLException ex) {
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
	public boolean checkDocState(String utenteUsername) {
		// TODO Auto-generated method stub
		return false;
	}
}

