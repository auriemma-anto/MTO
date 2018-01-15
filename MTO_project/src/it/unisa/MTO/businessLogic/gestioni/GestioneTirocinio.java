package it.unisa.MTO.businessLogic.gestioni;

import java.util.ArrayList;

import it.unisa.MTO.common.Tirocinio;
import it.unisa.MTO.storage.DAO.TirociniDAO;
import it.unisa.MTO.storage.connection.ConnessioneException;
import it.unisa.MTO.storage.interfaces.ITirociniDAO;

public class GestioneTirocinio {
	
	public GestioneTirocinio(){}
	
	public boolean modificaTirocinio(Tirocinio tirocinio){
		boolean toReturn = false;
		ITirociniDAO connection;
		try {
			connection = new TirociniDAO();
			toReturn = connection.modifyTirocinio(tirocinio);
		} catch (ConnessioneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return toReturn;
	}
	
	public boolean aggiungiTirocinio(Tirocinio tirocinio){
		boolean toReturn = false;
		ITirociniDAO connection;
		try {
			connection = new TirociniDAO();
			toReturn = connection.addTirocinio(tirocinio);
		} catch (ConnessioneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return toReturn;
	}
	
	public boolean eliminaTirocinio(int id){
		boolean toReturn = false;
		ITirociniDAO connection;
		try {
			connection = new TirociniDAO();
			toReturn = connection.deleteTirocinio(id);
		} catch (ConnessioneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return toReturn;
	}
	
	public ArrayList<Tirocinio> listaTirocini(){
		ArrayList<Tirocinio> toReturn = new ArrayList<Tirocinio>();
		ITirociniDAO connection;
		try {
			connection = new TirociniDAO();
			toReturn = connection.getTirocinioList();
		} catch (ConnessioneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return toReturn;
	}
	
	public void ricerchePerParametri(){}
	
	public Tirocinio getTirocinio(int id){
		Tirocinio toReturn = new Tirocinio();
		ITirociniDAO connection;
		try {
			connection = new TirociniDAO();
			toReturn = connection.getTirocinio(id);
		} catch (ConnessioneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return toReturn;
	}
}
