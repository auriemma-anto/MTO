package it.unisa.MTO.testing.businessLogic.gestioni;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unisa.MTO.businessLogic.gestioni.GestioneRichiesteTirocinio;
import it.unisa.MTO.common.DocumentoRichiesta;
import it.unisa.MTO.common.Firma;
import it.unisa.MTO.common.Utente;
import it.unisa.MTO.storage.DAO.GestioneRichiesteTirocinioDAO;
import it.unisa.MTO.storage.connection.ConnessioneException;
import it.unisa.MTO.storage.interfaces.IGRichiestaTirocinioDAO;

public class GestioneRichiestaTirocinioTest {


	GestioneRichiesteTirocinio grt;
	Utente user;
	DocumentoRichiesta doc;
	IGRichiestaTirocinioDAO grtDAO;

	@Before
	public void setUp() throws Exception {
		grt = new GestioneRichiesteTirocinio();
		grtDAO = new GestioneRichiesteTirocinioDAO();
		user = new Utente();
		user.setUsername("ericsson.resp");

		doc = new DocumentoRichiesta();
		doc.setCodiceID(1);
	}

	@After
	public void tearDown() throws Exception {
		grt = null;
	}

	@Test
	public void visualizzaListaTest() throws ConnessioneException {
		boolean test = true;
		ArrayList<DocumentoRichiesta> list = grt.visualizzaLista(user);
		Utente u = new Utente();
		u.setUsername("ericsson.resp");

		ArrayList<DocumentoRichiesta> listTest = grtDAO.getList(u);

		if(list.size() != listTest.size()){
			test = false;
		}
		else{
			for(int i=0; i<list.size(); i++){
				if(listTest.get(i).getCodiceID() != list.get(i).getCodiceID()){
					test = false;
				}
			}
		}
		assertEquals(true, test);
	}

	@Test
	public void firmaTest(){
		boolean test = true;
		grt.firma(doc, user, true);
		ArrayList<Firma> listFirme = grtDAO.checkDocState(doc).getFirma();
		
		if(!listFirme.get(0).getUtente().getUsername().equals("ericsson.resp") || listFirme.get(0).getValore() != true){
			test = false;
		}
		
		assertEquals(true, test);
	}


	@Test
	public void visualizzaStatoTest(){
		boolean test = true;
		DocumentoRichiesta d = grt.visualizzaStato(doc);
		
		ArrayList<Firma> listFirme = d.getFirma();
		
		if(!listFirme.get(0).getUtente().getUsername().equals("ericsson.resp") || listFirme.get(0).getValore() != true){
			test = false;
		}
		
		assertEquals(true, test);
	}

}

