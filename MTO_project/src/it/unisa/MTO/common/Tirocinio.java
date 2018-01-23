package it.unisa.MTO.common;

import java.sql.Date;

/**
 * Classe di riferimento dell'entità <b>Tirocinio</b> nel <b>DataBase</b>
 * @author Maurizio
 *
 */
public class Tirocinio {

	private int codiceID;
	private String rif_utente;
	private String azienda;
	private String dataInizio;
	private String dataFine;
	private String luogo;
	private String tematica;
	private String descrizione;
	
	public Tirocinio(){}
	
	public Tirocinio(String responsabileAziendale, String azienda, String dataInizio, String dataFine,
			String luogo, String tematica, String descrizione) {
		this.rif_utente = responsabileAziendale;
		this.azienda = azienda;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.luogo = luogo;
		this.tematica = tematica;
		this.descrizione = descrizione;
	}



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

	public String getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}

	public String getDataFine() {
		return dataFine;
	}

	public void setDataFine(String dataFine) {
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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getRif_utente() {
		return rif_utente;
	}

	public void setRif_utente(String responsabileAziendale) {
		this.rif_utente = responsabileAziendale;
	}
	
}
