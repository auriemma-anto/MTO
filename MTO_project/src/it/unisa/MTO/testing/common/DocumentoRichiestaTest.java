package it.unisa.MTO.testing.common;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unisa.MTO.common.DocumentoRichiesta;
import it.unisa.MTO.common.Firma;
import it.unisa.MTO.common.Tirocinio;
import it.unisa.MTO.common.Utente;

public class DocumentoRichiestaTest {

	private DocumentoRichiesta doc;
	DocumentoRichiesta doc2 = new DocumentoRichiesta();
	
	private ArrayList<Firma> firme = new ArrayList<Firma>();
	private Tirocinio tirocinio = new Tirocinio();
	private Utente studente = new Utente();
	private InputStream file = null;
	
	@Before
	public void setUp() throws Exception {
		doc = new DocumentoRichiesta();
		doc.setCodiceID(0);
		doc.setFile(file);
		doc.setFirma(firme);
		doc.setNome("");
		doc.setStudente(studente);
		doc.setTirocinio(tirocinio);
		
	}

	@After
	public void tearDown() throws Exception {
		doc = null;
	}

	@Test
	public void testAllGet() {
		assertEquals(0, doc.getCodiceID());
		assertEquals(file, doc.getFile());
		assertEquals(firme, doc.getFirma());
		assertEquals("", doc.getNome());
		assertEquals(studente, doc.getStudente());
		assertEquals(tirocinio, doc.getTirocinio());
		
	}
	
	@Test
	public void testAllSet(){
		
		ArrayList<Firma> f = new ArrayList<Firma>();
		Utente s = new Utente();
		Tirocinio t = new Tirocinio();
		
		doc2.setCodiceID(0);
		doc2.setFile(null);
		doc2.setFirma(f);
		doc2.setNome("");
		doc2.setStudente(s);
		doc2.setTirocinio(t);
		
		assertEquals(0, doc2.getCodiceID());
		assertEquals(null, doc2.getFile());
		assertEquals(f, doc2.getFirma());
		assertEquals("", doc2.getNome());
		assertEquals(s, doc2.getStudente());
		assertEquals(t, doc2.getTirocinio());
		
	}

}
