package it.unisa.MTO.businessLogic.gestioni;

import java.sql.Date;
import java.text.ParseException;

import it.unisa.MTO.common.Utente;
import it.unisa.MTO.common.UtenteType;
import it.unisa.MTO.storage.connection.ConnessioneException;
import it.unisa.MTO.storage.test.*;

public class GestioneAccount {

	public GestioneAccount(){
		
	}
	
	public boolean login(String username, String password){
		TestAccessUser test;
		try {
			test = new TestAccessUser();
			return test.getLogin(username, password);
		} catch (ConnessioneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void logout(){}
	
	public boolean registrazione(Utente utente) throws ParseException{
		
		TestAccessUser test;
		try {
			test = new TestAccessUser();
			return test.getRegistrazione(utente);
		} catch (ConnessioneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
		
		
	
}
