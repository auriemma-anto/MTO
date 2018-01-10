package it.unisa.MTO.storage.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.unisa.MTO.common.*;

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
	
}
