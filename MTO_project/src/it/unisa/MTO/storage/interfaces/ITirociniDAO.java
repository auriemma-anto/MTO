package it.unisa.MTO.storage.interfaces;

import java.util.ArrayList;

import it.unisa.MTO.common.Tirocinio;

public interface ITirociniDAO {

	public Tirocinio getTirocinio(int id);
	public boolean deleteTirocinio(int id);
	public ArrayList<Tirocinio> getTirocinioList();
	public boolean addTirocinio(Tirocinio tirocinio);
	public boolean modifyTirocinio(Tirocinio tirocinio);
	
}
