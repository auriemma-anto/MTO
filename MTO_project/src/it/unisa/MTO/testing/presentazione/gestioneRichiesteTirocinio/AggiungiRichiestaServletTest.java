package it.unisa.MTO.testing.presentazione.gestioneRichiesteTirocinio;

import static org.junit.Assert.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import it.unisa.MTO.common.Tirocinio;
import it.unisa.MTO.common.Utente;
import it.unisa.MTO.presentazione.gestioneRichiesteTirocinio.AggiungiRichiestaServlet;

public class AggiungiRichiestaServletTest { //da eliminare
	AggiungiRichiestaServlet servlet; 
	HttpServletRequest request; 
	HttpServletResponse response; 
	HttpSession session; 
	RequestDispatcher dispatcher; 
	ServletContext servletContext; 

	@Before
	public void setUp() throws Exception {
		servlet = new AggiungiRichiestaServlet();
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
	    session = mock(HttpSession.class);
	    dispatcher = mock(RequestDispatcher.class);
	    servletContext = mock(ServletContext.class);
	}

	@After
	public void tearDown() throws Exception {
		request = null;
	    response = null;
	}

	@Test
	public void test() {
		
	Utente studente = new Utente(); 
	Tirocinio tirocinio = new Tirocinio();
	
	when(request.getSession()).thenReturn(session);
	when(session.getAttribute("username")).thenReturn("c.desantis");
	when(request.getParameter("codiceTirocinio")).thenReturn("1");
	//when(request.getPart("documento")).thenReturn();	
	String path = servletContext.getRealPath("/PF.pdf");
	//File f = 
	when(request.getServletContext()).thenReturn(servletContext);
		
		
		
	}

}
