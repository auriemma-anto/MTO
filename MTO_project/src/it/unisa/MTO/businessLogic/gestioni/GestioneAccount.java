package it.unisa.MTO.businessLogic.gestioni;

import it.unisa.MTO.storage.connection.*;

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
	
	public void registrazione(){}
}
