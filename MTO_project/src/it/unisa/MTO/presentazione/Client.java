package it.unisa.MTO.presentazione;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import it.unisa.MTO.businessLogic.Facade;
import it.unisa.MTO.common.*;
import it.unisa.MTO.common.UtenteType;
import it.unisa.MTO.storage.connection.ConnessioneException;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Facade f = new Facade();
		Utente utente = new Utente("nano", "poi", "n.n@gmail.com", UtenteType.studente, "nano", "bb", "121212", "12/12", 12, "uni", "inf", "");
		//Utente utente1 = new Utente("nano", "poi", "n.n@gmail.com", UtenteType.studente, "nano", "bb", "121212", "12/12", 12, "uni", "inf", "");
		
		boolean res = false;
		boolean res1 = false;
		boolean tir1 = false;
		boolean tir2 = false;
		ArrayList<Tirocinio> listaTir = new ArrayList<Tirocinio>();
		ArrayList<Tirocinio> listaRicTir = new ArrayList<Tirocinio>();
		try {
			res = f.login("r.napo12", "ciao");
			res1 = f.registrazione(utente);
			listaTir = f.listaTirocinio();
			listaRicTir = f.ricercaTirociniPerParametri(ParamType.nomeResponsabileAzienda, "nano");
		} catch (ConnessioneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(res);
		System.out.println(res1);
		
		System.out.println("TIROCINIO");
		System.out.println(tir1);
		System.out.println(tir2);
		
		for (Tirocinio tirocinio : listaTir) {
			System.out.println(tirocinio.getDescrizione());
		}
		
		for (Tirocinio tirocinio : listaRicTir) {
			System.out.println(tirocinio.getAzienda());
		}
	}

}
