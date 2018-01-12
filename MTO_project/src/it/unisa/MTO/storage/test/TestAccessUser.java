package it.unisa.MTO.storage.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import it.unisa.MTO.common.*;
import it.unisa.MTO.storage.connection.AccessoDB;
import it.unisa.MTO.storage.connection.ConnessioneException;

public class TestAccessUser {

	private AccessoDB db;
	
	public TestAccessUser() throws ConnessioneException{
		db = new AccessoDB();
	}
	
	public boolean getLogin(String user, String pass){
		Connection conn = db.getConnessione();
		String query = "select count(username) from utente where username = '" + user + "' and password = '" + pass + "';";
		
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet res = statement.executeQuery(query);
			res.next();
			return res.getInt(1) == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
		public boolean getRegistrazione(Utente utente) throws ParseException {
		Connection conn = db.getConnessione();
		
		String username = utente.getUsername();
		String password = utente.getPassword();
		String email = utente.getEmail();
		UtenteType tipo = utente.getTipo();
		String nome = utente.getNome();
		String cognome = utente.getCognome();
		String dataNascita = utente.getDataNascita();
		String annoImmatricolazione = utente.getAnnoImmatricolazione();
		int cfu = utente.getCfu();
		String universita = utente.getUniversita();
		String dipartimento = utente.getDipartimento();
		String azienda = utente.getAzienda();
		
		/**
		 * format.parse(dataNascita) gli passo una Stringa e alla fine mi da.
		 * @param sql è di tipo yyyy-mm-dd
		 */
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date parsed = format.parse(dataNascita);
      
        java.sql.Date sql_date = new java.sql.Date(parsed.getTime());
        
		String query = "INSERT INTO utente (username, password, email, tipo, nome, cognome, "
				+ "data_nascita, annoImmatricolazione, CFU, universita, dipartimento, azienda)"
				+ " VALUES('"+username+"',"+ " '"+password+"', '"+email+"', '"+tipo+"', '"
				+nome+"', '"+cognome+"', '"+sql_date+"', '"+annoImmatricolazione+"' , "
				+cfu+", '"+universita+"', '"+dipartimento+"', '"+azienda+"');";
		
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.executeUpdate(query);
			statement.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
