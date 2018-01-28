package it.unisa.MTO.testing.presentazione.gestioneRichiesteTirocinio;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import java.io.IOException;

import it.unisa.MTO.presentazione.gestioneRichiesteTirocinio.FirmaRichiestaServlet;

public class FirmaRichiesteServletTest {

	HttpServletRequest request;
	HttpServletResponse response;
	HttpSession session;
	RequestDispatcher dispatcher;
	ServletContext servletContext;
	FirmaRichiestaServlet servlet;
	
	@Before
	public void setUp() throws Exception {
		servlet = new FirmaRichiestaServlet();
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		session = mock(HttpSession.class);
		dispatcher = mock(RequestDispatcher.class);
		servletContext = mock(ServletContext.class);
		servlet.init();
	}

	@After
	public void tearDown() throws Exception {	
		request = null;
		response = null;
	}

	@Test
	public void test() throws ServletException, IOException {
		when(request.getParameter("firma")).thenReturn("true");
		when(request.getParameter("username")).thenReturn("s.latorre");
		when(request.getParameter("documento")).thenReturn("1");
		
		when(request.getServletContext()).thenReturn(servletContext);
		when(servletContext.getRequestDispatcher("/ShowLista.jsp")).thenReturn(dispatcher);
		
		servlet.doGet(request, response);
		verify(dispatcher).forward(request, response);
		
		
	}

}