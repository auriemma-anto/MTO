package it.unisa.MTO.storage.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import it.unisa.MTO.common.*;
import it.unisa.MTO.storage.connection.AccessoDB;
import it.unisa.MTO.storage.connection.ConnessioneException;
import it.unisa.MTO.storage.interfaces.ITirociniDAO;

/**
 * Classe che si occupa della connessione ad <b>DataBase</b> relativamente alle azioni eseguite sull'entità <b>Tirocinio</b>
 * 
 * @author Maurizio
 *
 */
public class TirociniDAO implements ITirociniDAO {

	private AccessoDB db;
	private Connection conn;
	
	public TirociniDAO() throws ConnessioneException {
		db = new AccessoDB();
		conn = db.getConnessione();
	}
	
	/**
	 * Metodo che restituisce un {@link Tirocinio} dato il suo codice id
	 * @param id del tirocinio
	 * @return restituisce un {@link Tirocinio}
	 */
	@Override
	public Tirocinio getTirocinio(int id) {
		Tirocinio tirocinio = new Tirocinio();
		String query = "SELECT * FROM tirocinio WHERE codiceID = " + id + ";";
		
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet res = statement.executeQuery();
			
			res.next();
			
			tirocinio.setCodiceID(res.getInt(1));
			tirocinio.setRif_utente(res.getString(2));
			tirocinio.setAzienda(res.getString(3));
			tirocinio.setDataInizio(res.getString(4));
			tirocinio.setDataFine(res.getString(5));
			tirocinio.setLuogo(res.getString(6));
			tirocinio.setTematica(res.getString(7));
			tirocinio.setDescrizione(res.getString(8));
			
			res.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tirocinio;
	}

	/**
	 * Metodo che elimina un <b>Tirocinio</b> nel <b>DataBase</b> dato il suo id
	 * @param id del tirocinio
	 * @return <b>true</b> in caso di avvenuta cancellazione, <b>false</b> altrimenti
	 */
	@Override
	public boolean deleteTirocinio(int id) {
		boolean toReturn = false;
		String query = "DELETE FROM tirocinio WHERE codiceID = " + id + ";";
		
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			int res = statement.executeUpdate();
			toReturn = res > 0;
			
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return toReturn;
	}
	
	/**
	 * Restituisce la lista completa dei <b>Tirocini</b> presente nel <b>Database</b>
	 * @return restituisce un {@link java.util.ArrayList} di {@link Tirocinio}
	 */
	@Override
	public ArrayList<Tirocinio> getTirocinioList() {
		return ricercaPerParametri(ParamType.none, "");
	}

	/**
	 * Metodo che aggiunge un <b>Tirocinio</b> nel <b>DataBase</b>
	 * @param tirocinio {@link Tirocinio} da aggiungere
	 * @return <b>true</b> in caso di avvenuta aggiunta, <b>false</b> altrimenti
	 */
	@Override
	public boolean addTirocinio(Tirocinio tirocinio) {
		boolean toReturn = false;
		String query = "INSERT INTO tirocinio (rif_utente, azienda, data_inizio, data_fine, luogo, tematica, descrizione)"
				+ " values (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			
			statement.setString(1, tirocinio.getRif_utente());
			statement.setString(2, tirocinio.getAzienda());
			statement.setString(3, tirocinio.getDataInizio());
			statement.setString(4, tirocinio.getDataFine());
			statement.setString(5, tirocinio.getLuogo());
			statement.setString(6, tirocinio.getTematica());
			statement.setString(7, tirocinio.getDescrizione());
			
			int res = statement.executeUpdate();
			toReturn = res > 0;
			
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return toReturn;
	}

	/**
	 * Metodo che modifica un <b>Tirocinio</b> nel <b>DataBase</b>
	 * @param tirocinio {@link Tirocinio} da modificare
	 * @return <b>true</b> in caso di avvenuta modifica, <b>false</b> altrimenti
	 */
	@Override
	public boolean modifyTirocinio(Tirocinio tirocinio) {
		boolean toReturn = false;
		String query = "UPDATE tirocinio SET rif_utente = ?, azienda = ?, data_inizio = ?, "
				+ "data_fine = ?, luogo = ?, tematica = ?, descrizione = ? WHERE codiceID = ?";
		
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			
			statement.setString(1, tirocinio.getRif_utente());
			statement.setString(2, tirocinio.getAzienda());
			statement.setString(3, tirocinio.getDataInizio());
			statement.setString(4, tirocinio.getDataFine());
			statement.setString(5, tirocinio.getLuogo());
			statement.setString(6, tirocinio.getTematica());
			statement.setString(7, tirocinio.getDescrizione());
			statement.setInt(8, tirocinio.getCodiceID());
			
			int res = statement.executeUpdate();
			toReturn = res > 0;
			
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return toReturn;
	}

	private String getParamQuery(ParamType type, String param){		
		switch(type){
		case nomeResponsabileAzienda:
			return "SELECT * FROM tirocinio WHERE rif_utente = '" + param + "';";
		case nomeAzienda:
			return "SELECT * FROM tirocinio WHERE azienda = '" + param + "';";
		case luogo:
			return "SELECT * FROM tirocinio WHERE luogo = '" + param + "';";
		case none:
			return "SELECT * FROM tirocinio";
		default:
			return "SELECT * FROM tirocinio";
		}
	}
	
	/**
	 * Restituisce la lista filtrata dei <b>Tirocini</b> presente nel <b>Database</b>
	 * @param type tipo di filtro da applicare alla ricerca ({@link ParamType})
	 * @param param parametro
	 * @return restituisce un {@link java.util.ArrayList} di {@link Tirocinio}
	 */
	@Override
	public ArrayList<Tirocinio> ricercaPerParametri(ParamType type, String param) {
		ArrayList<Tirocinio> toReturn = new ArrayList<Tirocinio>();
		String query = getParamQuery(type, param);
		
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet res = statement.executeQuery();
			
			while(res.next()){
				Tirocinio tirocinio = new Tirocinio();
				tirocinio.setCodiceID(res.getInt(1));
				tirocinio.setRif_utente(res.getString(2));
				tirocinio.setAzienda(res.getString(3));
				tirocinio.setDataInizio(res.getString(4));
				tirocinio.setDataFine(res.getString(5));
				tirocinio.setLuogo(res.getString(6));
				tirocinio.setTematica(res.getString(7));
				tirocinio.setDescrizione(res.getString(8));
				
				toReturn.add(tirocinio);
			}
			
			res.close();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return toReturn;
	}

	
	
}
