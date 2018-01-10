package it.unisa.MTO.common;

import java.sql.Date;

public class Tirocinio {

	private int codiceID;
	private String azienda;
	private Date dataInizio;
	private Date dataFine;
	private String luogo;
	private String tematica;
	private String descizione;
	
	public Tirocinio(){}
	
	public int getCodiceID() {
		return codiceID;
	}

	public void setCodiceID(int codiceID) {
		this.codiceID = codiceID;
	}

	public String getAzienda() {
		return azienda;
	}

	public void setAzienda(String azienda) {
		this.azienda = azienda;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public String getTematica() {
		return tematica;
	}

	public void setTematica(String tematica) {
		this.tematica = tematica;
	}

	public String getDescizione() {
		return descizione;
	}

	public void setDescizione(String descizione) {
		this.descizione = descizione;
	}
	
}
