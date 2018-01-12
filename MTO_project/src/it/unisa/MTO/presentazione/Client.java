package it.unisa.MTO.presentazione;

import java.text.ParseException;

import it.unisa.MTO.businessLogic.Facade;
import it.unisa.MTO.common.Utente;
import it.unisa.MTO.common.UtenteType;

public class Client {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Facade f = new Facade();
		boolean res = f.login("r.napo12", "ciao");
		
		Facade fac = new Facade();
		
		Utente utente = new Utente("MAD", "MAD", "email", UtenteType.valueOf("studente"), "nome", "cognome", "11-08-1230", "2017/18", 13, "universita", "dipartimento", "azienda");
		
		System.out.println(utente.toString());
		
		boolean ris = f.registrazione(utente);
		
		System.out.println(ris);
	}

}
