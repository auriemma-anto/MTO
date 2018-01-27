package it.unisa.MTO.common;


/**
 * Classe di riferimento dell'entità <b>Tirocinio</b> nel <b>DataBase</b>.
 * @author Maurizio
 *
 */
public class Tirocinio {

	private int codiceID;
	private String rif_utente;
	private String rif_TA;
	private String rif_TE;
	private String azienda;
	private String dataInizio;
	private String dataFine;
	private String luogo;
	private String tematica;
	private String descrizione;
	
	public Tirocinio(){}
	
	public Tirocinio(int codiceID, String rif_utente, String rif_TA, String rif_TE, String azienda, String dataInizio, String dataFine,
			String luogo, String tematica, String descizione) {
		this.codiceID = codiceID;
		this.rif_utente = rif_utente;
		this.rif_TA = rif_TA;
		this.rif_TE = rif_TE;
		this.azienda = azienda;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.luogo = luogo;
		this.tematica = tematica;
		this.descrizione = descizione;
	}

	public Tirocinio(String rif_utente, String rif_TA, String rif_TE, String azienda, String dataInizio, String dataFine,
			String luogo, String tematica, String descizione) {
		this.rif_utente = rif_utente;
		this.rif_TA = rif_TA;
		this.rif_TE = rif_TE;
		this.azienda = azienda;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.luogo = luogo;
		this.tematica = tematica;
		this.descrizione = descizione;
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
	
	public String getRif_TA() {
		return rif_TA;
	}

	public void setRif_TA(String rif_TA) {
		this.rif_TA = rif_TA;
	}
	
	public String getRif_TE() {
		return rif_TE;
	}

	public void setRif_TE(String rif_TE) {
		this.rif_TE = rif_TE;
	}
	
	@Override
	public String toString() {
		return "Tirocinio [codiceID=" + codiceID + ", rif_utente=" + rif_utente + ", rif_TA=" + rif_TA + ", rif_TE="
				+ rif_TE + ", azienda=" + azienda + ", dataInizio=" + dataInizio + ", dataFine=" + dataFine + ", luogo="
				+ luogo + ", tematica=" + tematica + ", descrizione=" + descrizione + "]";
	}
	
}
