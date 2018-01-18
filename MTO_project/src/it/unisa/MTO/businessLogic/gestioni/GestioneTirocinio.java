package it.unisa.MTO.businessLogic.gestioni;

import java.util.ArrayList;

import it.unisa.MTO.common.Tirocinio;
import it.unisa.MTO.storage.DAO.TirociniDAO;
import it.unisa.MTO.storage.connection.ConnessioneException;
import it.unisa.MTO.storage.interfaces.ITirociniDAO;

public class GestioneTirocinio {
	
	public GestioneTirocinio(){}
	
	public boolean modificaTirocinio(Tirocinio tirocinio) throws ConnessioneException{
		ITirociniDAO connection = new TirociniDAO();
		return connection.modifyTirocinio(tirocinio);
	}
	
	public boolean aggiungiTirocinio(Tirocinio tirocinio) throws ConnessioneException{
		ITirociniDAO connection = new TirociniDAO();
		return connection.addTirocinio(tirocinio);
	}
	
	public boolean eliminaTirocinio(int id) throws ConnessioneException{
		ITirociniDAO connection = new TirociniDAO();
		return connection.deleteTirocinio(id);
	}
	
	public ArrayList<Tirocinio> listaTirocini() throws ConnessioneException{
		ArrayList<Tirocinio> toReturn = new ArrayList<Tirocinio>();
		ITirociniDAO connection = new TirociniDAO();
		toReturn = connection.getTirocinioList();;
		
		return toReturn;
	}
	
	public void ricerchePerParametri(){}//TODO: fare ricerca per parametri
	
	public Tirocinio getTirocinio(int id) throws ConnessioneException{
		Tirocinio toReturn = new Tirocinio();
		ITirociniDAO connection = new TirociniDAO();
		toReturn = connection.getTirocinio(id);
		
		return toReturn;
	}
}
