package it.unisa.MTO.common;

public class Firma {

	private Utente utente; 
	private boolean valore;
	
	public Firma() {}
	
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public boolean getValore() {
		return valore;
	}
	public void setValore(boolean valore) {
		this.valore = valore;
	} 
	
}
