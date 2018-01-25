package it.unisa.MTO.storage.DAO;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.MTO.common.DocumentoRichiesta;
import it.unisa.MTO.common.Firma;
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


		String select1 = "(SELECT username FROM utente WHERE username='"+username+"')";
		String select2 = "(SELECT codiceID FROM tirocinio WHERE codiceID="+codiceTir+")";
		String query = "INSERT INTO documento (nome, rif_utente, rif_tirocinio, file) "
				+ "VALUES (?,"+select1+","+select2+",?);";

		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, nomeFile);

			if (file != null) {
				// Inserisce l'inputStream per l'upload dei file nella colonna blob
				statement.setBlob(2, file);
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
	public DocumentoRichiesta getDocument(DocumentoRichiesta doc) {
		// TODO Auto-generated method stub
		InputStream inputStream = null;
		Utente studente = doc.getStudente();
		String username = studente.getUsername();


		Connection conn = db.getConnessione();

		String query = "SELECT * FROM documento WHERE rif_utente = '"+username+"';";

		try {
			PreparedStatement statement = conn.prepareStatement(query);

			System.out.println(""+statement);
			ResultSet res = statement.executeQuery(query);

			if(res.next()) {
				doc.setCodiceID(res.getInt("codiceID"));
				doc.setNome(res.getString("nome"));

				Tirocinio tirocinio = new Tirocinio();
				tirocinio.setCodiceID(res.getInt("rif_tirocinio"));
				doc.setTirocinio(tirocinio);

				Blob blob = res.getBlob("file");
				inputStream = blob.getBinaryStream();
				doc.setFile(inputStream);
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
		return doc;
	}

	@Override
	public ArrayList<DocumentoRichiesta> getList(Tirocinio tirocinio, Utente studente) {
		// TODO Auto-generated method stub

		Connection conn = db.getConnessione();

		ArrayList<DocumentoRichiesta> lista = new ArrayList<DocumentoRichiesta>();

		String query = null;


		try {

			if(tirocinio.getCodiceID()>0){
				int codiceID = tirocinio.getCodiceID();
				query = "SELECT * FROM documento WHERE rif_tirocinio="+codiceID+";";
			}

			else if(!studente.getUsername().isEmpty()){
				String username = studente.getUsername();
				query = "SELECT * FROM documento WHERE rif_utente='"+username+"';";

			}

			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet res = statement.executeQuery(query);

			System.out.println("DAO: "+statement);

			while(res.next()) {
				DocumentoRichiesta doc = new DocumentoRichiesta();
				doc.setCodiceID(res.getInt("codiceID"));
				doc.setNome(res.getString("nome"));

				Tirocinio tir = new Tirocinio();
				tir.setCodiceID(res.getInt("rif_tirocinio"));
				doc.setTirocinio(tir);
				
				Utente st = new Utente();
				st.setUsername(res.getString("rif_utente"));

				String selectStudente = "SELECT * FROM utente WHERE username='"+res.getString("rif_utente")+"';";

				PreparedStatement statement2 = conn.prepareStatement(selectStudente);					
				ResultSet rs = statement2.executeQuery(selectStudente);

				System.out.println("DAO: "+statement2);
				
				if(rs.next()){
					st.setNome(rs.getString("nome"));
					st.setCognome(rs.getString("cognome"));
					st.setEmail(rs.getString("email"));
					st.setCfu(rs.getInt("CFU"));
					st.setUniversita(rs.getString("universita"));
					st.setUsername(rs.getString("username"));
				}
				
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

	public boolean markDocument(DocumentoRichiesta documento, Utente utente, boolean firma) {

		Connection conn = db.getConnessione(); 

		String select1 = "(SELECT username FROM utente WHERE username='"+utente.getUsername()+"')";
		String select2 = "(SELECT codiceID FROM documento WHERE codiceID="+documento.getCodiceID()+")";
		String query = "INSERT INTO firma (rif_utente, rif_documento, valore) VALUES ("+select1+", "+select2+", "+firma+");";

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

	public DocumentoRichiesta checkDocState(DocumentoRichiesta documento) {

		System.out.println("CheckDocState");
		System.out.println(""+documento.getCodiceID());

		Connection conn = db.getConnessione(); 
		String query = "SELECT * FROM firma WHERE rif_documento = "+documento.getCodiceID()+";";
		ArrayList<Firma> firme = new ArrayList<Firma>();

		try{

			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet res = statement.executeQuery(query);
			System.out.println(""+statement);
			System.out.println(res.equals(null));

			while(res.next()){
				Utente utente = new Utente();
				utente.setUsername(res.getString("rif_utente"));

				Firma firma = new Firma();
				firma.setUtente(utente);

				firma.setValore(res.getBoolean("valore"));

				System.out.println("DAO: "+firma.getUtente().getUsername());
				System.out.println("DAO: "+firma.getValore());

				firme.add(firma);
			}

			documento.setFirma(firme);

			return documento;

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
		return null;
	}
}

