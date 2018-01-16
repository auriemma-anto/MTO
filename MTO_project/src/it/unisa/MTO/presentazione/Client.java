package it.unisa.MTO.presentazione;

import it.unisa.MTO.businessLogic.Facade;
import it.unisa.MTO.storage.connection.ConnessioneException;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Facade f = new Facade();
		boolean res = false;
		try {
			res = f.login("r.napo12", "ciao");
		} catch (ConnessioneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(res);
	}

}
