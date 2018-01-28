package it.unisa.MTO.testing.storage.DAO;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.PreparedStatement;

import it.unisa.MTO.common.DocumentoRichiesta;
import it.unisa.MTO.common.Firma;
import it.unisa.MTO.common.Tirocinio;
import it.unisa.MTO.common.Utente;
import it.unisa.MTO.storage.DAO.GestioneRichiesteTirocinioDAO;
import it.unisa.MTO.storage.connection.AccessoDB;
import it.unisa.MTO.storage.connection.ConnessioneException;

public class GestioneRichiestaTirocinioDAOTest{

	private AccessoDB db;
	GestioneRichiesteTirocinioDAO dao;
	DocumentoRichiesta doc2 = new DocumentoRichiesta();
	DocumentoRichiesta doc = new DocumentoRichiesta();
	Utente utente = new Utente();
	Utente respAz = new Utente();
	Tirocinio tirocinio = new Tirocinio();
	InputStream in = null;

	@Before
	public void setUp() throws ConnessioneException, IOException{
		utente.setUsername("c.desantis");
		respAz.setUsername("ericsson.resp");
		doc.setStudente(utente);
		tirocinio.setCodiceID(1);
		tirocinio.setRif_utente("ericsson.resp");
		tirocinio.setRif_TA("s.latorre");
		tirocinio.setRif_TE("a.demartino5");
		doc.setTirocinio(tirocinio);
		doc.setCodiceID(1);
		doc.setFile(null);
		doc2.setStudente(utente);
		doc2.setTirocinio(tirocinio);
		dao = new GestioneRichiesteTirocinioDAO();
		db = new AccessoDB();
	}

	@Test
	public void getListTest(){

		boolean test = true;
		Utente ut = new Utente();
		ArrayList<DocumentoRichiesta> list = dao.getList(utente);
		Connection conn = db.getConnessione();

		ArrayList<DocumentoRichiesta> listTest = new ArrayList<DocumentoRichiesta>();
		ut.setUsername("c.desantis");
		String query = null;

		try {

			String queryIdTirocinio = "SELECT codiceID FROM tirocinio WHERE (rif_utente='"+ut.getUsername()+"' OR rif_TE='"+ut.getUsername()+"' OR rif_TA='"+ut.getUsername()+"')";

			query = "SELECT * FROM documento WHERE rif_tirocinio IN ("+queryIdTirocinio+") OR rif_utente='"+ut.getUsername()+"';";

			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet res = statement.executeQuery(query);

			System.out.println("DAO: "+statement);

			while(res.next()) {
				DocumentoRichiesta doct = new DocumentoRichiesta();
				doct.setCodiceID(res.getInt("codiceID"));
				doct.setNome(res.getString("nome"));

				Tirocinio tir = new Tirocinio();
				tir.setCodiceID(res.getInt("rif_tirocinio"));
				doct.setTirocinio(tir);

				Utente utr = new Utente();
				ut.setUsername(res.getString("rif_utente"));

				String selectStudente = "SELECT * FROM utente WHERE username='"+res.getString("rif_utente")+"';";

				PreparedStatement statement2 = conn.prepareStatement(selectStudente);					
				ResultSet rs2 = statement2.executeQuery(selectStudente);

				System.out.println("DAO: "+statement2);

				if(rs2.next()){
					utr.setNome(rs2.getString("nome"));
					utr.setCognome(rs2.getString("cognome"));
					utr.setEmail(rs2.getString("email"));
					utr.setCfu(rs2.getInt("CFU"));
					utr.setUniversita(rs2.getString("universita"));
					utr.setUsername(rs2.getString("username"));
				}

				doct.setStudente(utr);
				listTest.add(doct);
				System.out.println("DAO: "+doct.getCodiceID());
				System.out.println("DAO: "+doct.getNome());
				System.out.println("DAO: "+doct.getTirocinio().getCodiceID());
				System.out.println("DAO: "+doct.getStudente().getUsername());
			}

		}catch (SQLException ex) {
			if (conn != null) {
				// closes the database connection
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			ex.printStackTrace();
		}

		if(list.size() != listTest.size()){
			test = false;
		}
		else{
			for(int i=0; i<list.size(); i++){
				if(listTest.get(i).getCodiceID() != list.get(i).getCodiceID() || !listTest.get(i).getNome().equals(list.get(i).getNome())){
					test = false;
				}
			}
		}
		assertEquals(true, test);


	}

	@Test
	public void markDocumentTest(){
		dao.markDocument(doc, respAz, true);
		Connection conn = db.getConnessione(); 

		String query = "SELECT * FROM firma WHERE rif_documento = "+doc.getCodiceID()+";";
		boolean test = true; 

		try{

			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet res = statement.executeQuery(query);
			while(res.next()){
				Utente utente = new Utente();
				utente.setUsername(res.getString("rif_utente"));

				Firma firma = new Firma();
				firma.setUtente(utente);

				firma.setValore(res.getBoolean("valore"));

				if(!firma.getUtente().getUsername().equals(respAz.getUsername()) || firma.getValore() != true){
					test = false;
				}
			}



		}catch (SQLException ex) {
			if (conn != null) {
				// closes the database connection
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			ex.printStackTrace();
		}


		assertEquals(true, test);

	}

	@Test
	public void checkdockStateTest() {

		boolean test = true;
		DocumentoRichiesta docTest = dao.checkDocState(doc);
		ArrayList<Firma> list = docTest.getFirma();

		if(!list.get(0).getUtente().getUsername().equals("ericsson.resp") || list.get(0).getValore() != true){
			test = false;
		}

		assertEquals(test, true);

	}



}
