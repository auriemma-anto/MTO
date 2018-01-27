package it.unisa.MTO.presentazione;

import java.text.ParseException;

import it.unisa.MTO.businessLogic.Facade;
import it.unisa.MTO.common.Utente;
import it.unisa.MTO.common.UtenteType;
import it.unisa.MTO.storage.connection.ConnessioneException;

public class Client {

	
	public static void main(String[] args) throws ConnessioneException, ParseException {
		// TODO Auto-generated method stub
		Facade f = new Facade();
		boolean res = false;
		boolean result;
		try {
			res = f.login("r.napo12", "ciao");
		} catch (ConnessioneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Utente utente = new Utente("cha", "napo", "c.ma@studente.unisa.it",  UtenteType.valueOf("studente"),
			       "chiara",  "napolitano", "12-12-1996",
			       "2015/16",  85,  "Unisa", "Archeologia");
		
		result = f.registrazione(utente);
		

		
		System.out.println("CLiente"+utente.toString());
		
		System.out.println(result);
		
		System.out.println(res);
	}

}
