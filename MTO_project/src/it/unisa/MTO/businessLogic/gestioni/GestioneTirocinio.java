package it.unisa.MTO.businessLogic.gestioni;

import java.util.ArrayList;

import it.unisa.MTO.common.ParamType;
import it.unisa.MTO.common.Tirocinio;
import it.unisa.MTO.storage.DAO.TirociniDAO;
import it.unisa.MTO.storage.connection.ConnessioneException;
import it.unisa.MTO.storage.interfaces.ITirociniDAO;

public class GestioneTirocinio {
	
	public GestioneTirocinio(){}
	
	/**
	 * Metodo che modifica un <b>Tirocinio</b> nel <b>DataBase</b>
	 * @param tirocinio {@link Tirocinio} da modificare
	 * @return <b>true</b> in caso di avvenuta modifica, <b>false</b> altrimenti
	 * @throws ConnessioneException
	 */
	public boolean modificaTirocinio(Tirocinio tirocinio) throws ConnessioneException{
		ITirociniDAO connection = new TirociniDAO();
		return connection.modifyTirocinio(tirocinio);
	}
	
	/**
	 * Metodo che aggiunge un <b>Tirocinio</b> nel <b>DataBase</b>
	 * @param tirocinio {@link Tirocinio} da aggiungere
	 * @return <b>true</b> in caso di avvenuta aggiunta, <b>false</b> altrimenti
	 * @throws ConnessioneException
	 */
	public boolean aggiungiTirocinio(Tirocinio tirocinio) throws ConnessioneException{
		ITirociniDAO connection = new TirociniDAO();
		return connection.addTirocinio(tirocinio);
	}
	
	/**
	 * Metodo che elimina un <b>Tirocinio</b> nel <b>DataBase</b> dato il suo id
	 * @param id del tirocinio
	 * @return <b>true</b> in caso di avvenuta cancellazione, <b>false</b> altrimenti
	 * @throws ConnessioneException
	 */
	public boolean eliminaTirocinio(int id) throws ConnessioneException{
		ITirociniDAO connection = new TirociniDAO();
		return connection.deleteTirocinio(id);
	}
	
	/**
	 * Restituisce la lista completa dei <b>Tirocini</b> presente nel <b>Database</b>
	 * @return restituisce un {@link java.util.ArrayList} di {@link Tirocinio}
	 * @throws ConnessioneException
	 */
	public ArrayList<Tirocinio> listaTirocini() throws ConnessioneException{
		ArrayList<Tirocinio> toReturn = new ArrayList<Tirocinio>();
		ITirociniDAO connection = new TirociniDAO();
		toReturn = connection.getTirocinioList();;
		
		return toReturn;
	}
	
	/**
	 * Restituisce la lista filtrata dei <b>Tirocini</b> presente nel <b>Database</b>
	 * @param type tipo di filtro da applicare alla ricerca ({@link ParamType})
	 * @param param parametro
	 * @return restituisce un {@link java.util.ArrayList} di {@link Tirocinio}
	 * @throws ConnessioneException
	 */
	public ArrayList<Tirocinio> ricerchePerParametri(ParamType type, String param) throws ConnessioneException{
		ArrayList<Tirocinio> toReturn = new ArrayList<Tirocinio>();
		ITirociniDAO connection = new TirociniDAO();
		toReturn = connection.ricercaPerParametri(type, param);
		
		return toReturn;
	}
	
	/**
	 * Metodo che restituisce un {@link Tirocinio} dato il suo codice id
	 * @param id del tirocinio
	 * @return restituisce un {@link Tirocinio}
	 * @throws ConnessioneException
	 */
	public Tirocinio getTirocinio(int id) throws ConnessioneException{
		Tirocinio toReturn = new Tirocinio();
		ITirociniDAO connection = new TirociniDAO();
		toReturn = connection.getTirocinio(id);
		
		return toReturn;
	}
}
