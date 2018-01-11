package it.unisa.MTO.storage.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.unisa.MTO.common.*;
import it.unisa.MTO.storage.connection.AccessoDB;
import it.unisa.MTO.storage.connection.ConnessioneException;

public class TestAccessUser {

	private AccessoDB db;
	
	public TestAccessUser() throws ConnessioneException {
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
	
	
		public boolean getRegistrazione(Utente utente) {
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
		
		/*  String query = "INSERT INTO utente ( username, password, email, tipo, nome, cognome, data_nascita, annoImmatricolazione, CFU, universita, dipartimento, azienda) VALUES ( '"+cliente.getUsername()+"',"
				+ " '"+cliente.getPassword()+"', '"+cliente.getNome()+"', '"+cliente.getCognome()+"', '"+cliente.getDataNascita()+"', '"+cliente.getPaese()+"', '"+cliente.getInd()+"', '"+cliente.getCF()+"' , '"+cliente.getCI()+"', '"+cliente.getPassaporto()+"', '"+cliente.getMail()+"', '"+cliente.getTel()+"');";
		*/
		String query ="INSERT INTO utente VALUES ()";
		
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
}
