package it.unisa.MTO.testing.presentazione.gestioneRichiesteTirocinio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.unisa.MTO.presentazione.gestioneRichiesteTirocinio.VisualizzaStatoRichiestaServlet;

public class VisualizzaStatiRichiestaServletTest {

	VisualizzaStatoRichiestaServlet servlet = new VisualizzaStatoRichiestaServlet();; 
	HttpServletRequest request; 
	HttpServletResponse response; 
	HttpSession session; 
	RequestDispatcher dispatcher; 
	ServletContext servletContext; 
	
	@Before
	public void setUp() throws Exception {
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
	public void test() throws ServletException, IOException {
		
		
		when(request.getSession()).thenReturn(session);
	    when(session.getAttribute("username")).thenReturn("r.napo12");
	    
	    when(request.getServletContext()).thenReturn(servletContext);
	    
	    when(request.getServletContext().getRequestDispatcher("/ShowStatoDocumento.jsp")).thenReturn(dispatcher);

	      
	    servlet.doGet(request, response);

	    verify(dispatcher).forward(request, response);
		
		
		
	}

}
