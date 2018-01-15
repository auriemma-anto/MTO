package it.unisa.MTO.storage.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;

import it.unisa.MTO.common.*;
import it.unisa.MTO.storage.connection.AccessoDB;
import it.unisa.MTO.storage.connection.ConnessioneException;
import it.unisa.MTO.storage.connection.exe.LoginFailedException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;




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


	public boolean getRegistrazione(Utente utente) throws ParseException, ServletException, IOException, ConnessioneException, JSONException {

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

		/**
		 * @param description è la stringa che viene mostrata in caso di errore
		 */
		String description = "Username già presente";
		JSONObject json = new JSONObject();


		try {

			if(getControlloUsername(username) == false){ //quindi l'username non esiste
				
				String queryRegistra = "INSERT INTO utente (username, password, email, tipo, nome, cognome, "
						+ "data_nascita, annoImmatricolazione, CFU, universita, dipartimento, azienda)"
						+ " VALUES('"+username+"',"+ " '"+password+"', '"+email+"', '"+tipo+"', '"
						+nome+"', '"+cognome+"', '"+sql_date+"', '"+annoImmatricolazione+"' , "
						+cfu+", '"+universita+"', '"+dipartimento+"', '"+azienda+"');";
				PreparedStatement statement = conn.prepareStatement(queryRegistra);
				statement.executeUpdate(queryRegistra);
				return true;
			}	
		}catch (SQLException e) {
			description = e.getMessage();
		}
		return false;   
		
	}
		

	public boolean getControlloUsername (String username) throws ServletException, SQLException, IOException{
		
		Connection conn = db.getConnessione();
		
		String queryControllo ="SELECT username FROM utente WHERE username ='"+ username + "';";
		PreparedStatement pStatement = conn.prepareStatement(queryControllo);
		ResultSet rs = pStatement.executeQuery(queryControllo);
		boolean exist = rs.next();
		rs.close();
		pStatement.close();
		System.out.println("esiste:" +exist);
		return exist;
		
		
	}
}
