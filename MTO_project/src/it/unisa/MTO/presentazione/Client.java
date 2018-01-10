package it.unisa.MTO.presentazione;

import it.unisa.MTO.businessLogic.Facade;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Facade f = new Facade();
		boolean res = f.login("r.napo12", "ciao");
		
		System.out.println(res);
	}

}
