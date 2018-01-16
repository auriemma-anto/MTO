package it.unisa.MTO.storage.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.MTO.common.*;
import it.unisa.MTO.storage.connection.AccessoDB;
import it.unisa.MTO.storage.connection.ConnessioneException;
import it.unisa.MTO.storage.interfaces.ITirociniDAO;

public class TirociniDAO implements ITirociniDAO {

	private AccessoDB db;
	private Connection conn;
	
	public TirociniDAO() throws ConnessioneException {
		db = new AccessoDB();
		conn = db.getConnessione();
	}
	
	@Override
	public Tirocinio getTirocinio(int id) {
		Tirocinio tirocinio = new Tirocinio();
		String query = "SELECT * FROM tirocio WHERE codiceID = " + id + ";";
		
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet res = statement.executeQuery();
			
			res.next();
			
			tirocinio.setCodiceID(res.getInt(1));
			tirocinio.setResponsabileAziendale(getUtente(res.getString(2)));
			tirocinio.setAzienda(res.getString(3));
			tirocinio.setDataInizio(res.getDate(4));
			tirocinio.setDataFine(res.getDate(5));
			tirocinio.setLuogo(res.getString(6));
			tirocinio.setTematica(res.getString(7));
			tirocinio.setDescizione(res.getString(8));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tirocinio;
	}

	@Override
	public boolean deleteTirocinio(int id) {
		boolean toReturn = false;
		String query = "DELETE FROM tirocinio WHERE codiceID = " + id + ";";
		
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			int res = statement.executeUpdate();
			toReturn = res > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return toReturn;
	}

	private Utente getUtente(String id){
		Utente utente = new Utente();
		String query = "SELECT * FROM utente WHERE username = " + id + ";";
		
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet res = statement.executeQuery();
			
			res.next();
			
			utente.setUsername(res.getString(1));
			utente.setPassword(res.getString(2));
			utente.setEmail(res.getString(3));
			utente.setTipo(UtenteType.valueOf(res.getString(4)));
			utente.setNome(res.getString(5));
			utente.setCognome(res.getString(6));
			utente.setDataNascita(res.getDate(7).toString());//TODO: vedi formato data
			utente.setAnnoImmatricolazione(res.getString(8));
			utente.setCfu(res.getInt(9));
			utente.setAzienda(res.getString(12));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return utente;
	}
	
	@Override
	public ArrayList<Tirocinio> getTirocinioList() {
		ArrayList<Tirocinio> toReturn = new ArrayList<Tirocinio>();
		String query = "SELECT * FROM tirocio";
		
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet res = statement.executeQuery();
			
			while(res.next()){
				Tirocinio tirocinio = new Tirocinio();
				tirocinio.setCodiceID(res.getInt(1));
				tirocinio.setResponsabileAziendale(getUtente(res.getString(2)));
				tirocinio.setAzienda(res.getString(3));
				tirocinio.setDataInizio(res.getDate(4));
				tirocinio.setDataFine(res.getDate(5));
				tirocinio.setLuogo(res.getString(6));
				tirocinio.setTematica(res.getString(7));
				tirocinio.setDescizione(res.getString(8));
				
				toReturn.add(tirocinio);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return toReturn;
	}

	@Override
	public boolean addTirocinio(Tirocinio tirocinio) {
		boolean toReturn = false;
		String query = "INSERT INTO tirocinio (codiceID, rif_utente, azienda, data_inizio, data_fine, luogo, tematica, descrizione)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			
			//codice auto incrementale---riferimento ad utente nel db?
			statement.setInt(1, tirocinio.getCodiceID());
			statement.setString(2, tirocinio.getResponsabileAziendale().getUsername());
			statement.setString(3, tirocinio.getAzienda());
			statement.setDate(4, tirocinio.getDataInizio());
			statement.setDate(5, tirocinio.getDataFine());
			statement.setString(6, tirocinio.getLuogo());
			statement.setString(7, tirocinio.getTematica());
			statement.setString(8, tirocinio.getDescizione());
			
			int res = statement.executeUpdate();
			toReturn = res > 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return toReturn;
	}

	@Override
	public boolean modifyTirocinio(Tirocinio tirocinio) {
		boolean toReturn = false;
		String query = "UPDATE tirocinio SET rif_utente = ?, azienda = ?, data_inizio = ?, "
				+ "data_fine = ?, luogo = ?, tematica = ?, descrizione = ?)";
		
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			
			statement.setString(1, tirocinio.getResponsabileAziendale().getUsername());
			statement.setString(2, tirocinio.getAzienda());
			statement.setDate(3, tirocinio.getDataInizio());
			statement.setDate(4, tirocinio.getDataFine());
			statement.setString(5, tirocinio.getLuogo());
			statement.setString(6, tirocinio.getTematica());
			statement.setString(7, tirocinio.getDescizione());
			
			int res = statement.executeUpdate();
			toReturn = res > 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return toReturn;
	}

	
	
}
