package it.unisa.MTO.storage.interfaces;

import java.util.ArrayList;

import it.unisa.MTO.common.ParamType;
import it.unisa.MTO.common.Tirocinio;

public interface ITirociniDAO {

	/**
	 * Metodo che restituisce un {@link Tirocinio} dato il suo codice id
	 * @param id del tirocinio
	 * @return restituisce un {@link Tirocinio}
	 */
	public Tirocinio getTirocinio(int id);
	
	/**
	 * Metodo che elimina un <b>Tirocinio</b> nel <b>DataBase</b> dato il suo id
	 * @param id del tirocinio
	 * @return <b>true</b> in caso di avvenuta cancellazione, <b>false</b> altrimenti
	 */
	public boolean deleteTirocinio(int id);
	
	/**
	 * Restituisce la lista completa dei <b>Tirocini</b> presente nel <b>Database</b>
	 * @return restituisce un {@link java.util.ArrayList} di {@link Tirocinio}
	 */
	public ArrayList<Tirocinio> getTirocinioList();
	
	/**
	 * Metodo che aggiunge un <b>Tirocinio</b> nel <b>DataBase</b>
	 * @param tirocinio {@link Tirocinio} da aggiungere
	 * @return <b>true</b> in caso di avvenuta aggiunta, <b>false</b> altrimenti
	 */
	public boolean addTirocinio(Tirocinio tirocinio);
	
	/**
	 * Metodo che modifica un <b>Tirocinio</b> nel <b>DataBase</b>
	 * @param tirocinio {@link Tirocinio} da modificare
	 * @return <b>true</b> in caso di avvenuta modifica, <b>false</b> altrimenti
	 */
	public boolean modifyTirocinio(Tirocinio tirocinio);
	
	/**
	 * Restituisce la lista filtrata dei <b>Tirocini</b> presente nel <b>Database</b>
	 * @param type tipo di filtro da applicare alla ricerca ({@link ParamType})
	 * @param param parametro
	 * @return restituisce un {@link java.util.ArrayList} di {@link Tirocinio}
	 */
	public ArrayList<Tirocinio> ricercaPerParametri(ParamType type, String param);
	
}
