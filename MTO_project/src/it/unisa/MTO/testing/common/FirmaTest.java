package it.unisa.MTO.testing.common;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unisa.MTO.common.Firma;
import it.unisa.MTO.common.Utente;

public class FirmaTest {
	
	private Firma firma;
	public Firma firma2 = new Firma();
	private Utente utente = new Utente();
	
	
	@Before
	public void setUp(){
		firma = new Firma ();
		firma.setUtente(utente);
		firma.setValore(true);
	}
	
	@After
	public void tearDown(){
		firma = null;
	}

	@Test
	public void testAllGet() {
		assertEquals(utente, firma.getUtente());
		assertEquals(true, firma.getValore());
	}
	
	@Test
	public void testAllSet(){
		Utente u = new Utente();
		firma2.setUtente(u);
		assertEquals(u, firma2.getUtente());
		
		firma2.setValore(false);
		assertEquals(false, firma2.getValore());
	}

}
