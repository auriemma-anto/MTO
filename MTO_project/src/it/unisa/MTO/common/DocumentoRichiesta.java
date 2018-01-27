package it.unisa.MTO.common;

public class DocumentoRichiesta {

	private int codiceID;
	private String nome;
	private Utente[] firme;
	private Tirocinio tirocinio;
	private Utente studente;
	
	
	public DocumentoRichiesta(){}
	
	public int getCodiceID() {
		return codiceID;
	}
	public void setCodiceID(int codiceID) {
		this.codiceID = codiceID;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Tirocinio getTirocinio() {
		return tirocinio;
	}
	public void setTirocinio(Tirocinio tirocinio) {
		this.tirocinio = tirocinio;
	}

	public Utente[] getFirma() {
		return firme;
	}

	public void setFirma(Utente[] firma) {
		this.firme = firma;
	}

	public Utente getStudente() {
		return studente;
	}

	public void setStudente(Utente studente) {
		this.studente = studente;
	}
	
	
	
}
