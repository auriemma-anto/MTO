package it.unisa.MTO.common;

/**
 * Classe di riferimento dell'entità <b>Utente</b> nel <b>DataBase</b>.
 * @author Maurizio
 *
 */
public class Utente {
	
	private String username;
	private String password;
	private String email;
	private UtenteType tipo;
	private String nome;
	private String cognome;
	private String dataNascita;
	private String annoImmatricolazione;
	private int cfu;
	private String universita;
	private String dipartimento;
	private String azienda;
	
	public Utente(){}

	public Utente(String username, String password, String email, UtenteType tipo, String nome, String cognome,
			String dataNascita, String annoImmatricolazione, int cfu, String universita, String dipartimento,
			String azienda) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.tipo = tipo;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.annoImmatricolazione = annoImmatricolazione;
		this.cfu = cfu;
		this.universita = universita;
		this.dipartimento = dipartimento;
		this.azienda = azienda;
	}
	
	public Utente(String username, String password, String email, UtenteType tipo, String nome, String cognome,
			String dataNascita, String annoImmatricolazione, int cfu, String universita, String dipartimento) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.tipo = tipo;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.annoImmatricolazione = annoImmatricolazione;
		this.cfu = cfu;
		this.universita = universita;
		this.dipartimento = dipartimento;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UtenteType getTipo() {
		return tipo;
	}

	public void setTipo(UtenteType tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getAnnoImmatricolazione() {
		return annoImmatricolazione;
	}

	public void setAnnoImmatricolazione(String annoImmatricolazione) {
		this.annoImmatricolazione = annoImmatricolazione;
	}

	public int getCfu() {
		return cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	public String getUniversita() {
		return universita;
	}

	public void setUniversita(String universita) {
		this.universita = universita;
	}

	public String getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(String dipartimento) {
		this.dipartimento = dipartimento;
	}

	public String getAzienda() {
		return azienda;
	}

	public void setAzienda(String azienda) {
		this.azienda = azienda;
	}
	
	
	
}
