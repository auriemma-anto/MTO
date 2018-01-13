package it.unisa.MTO.common;

import java.io.InputStream;
import java.util.ArrayList;

public class DocumentoRichiesta {

	private int codiceID;
	private String nome;
	private ArrayList<Firma> firme;
	private Tirocinio tirocinio;
	private Utente studente;
	private InputStream file;
	
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

	public ArrayList<Firma> getFirma() {
		return firme;
	}

	public void setFirma(ArrayList<Firma> firma) {
		this.firme = firma;
	}

	public Utente getStudente() {
		return studente;
	}

	public void setStudente(Utente studente) {
		this.studente = studente;
	}
	
	public InputStream getFile(){
		return file;
	}
	
	public void setFile(InputStream file){
		this.file = file;
	}
		
}
