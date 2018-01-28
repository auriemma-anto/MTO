package it.unisa.MTO.testing.presentazione.gestioneRichiesteTirocinio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

import it.unisa.MTO.presentazione.gestioneRichiesteTirocinio.ListaRichiesteTirociniServlet;

public class ListaRichiesteTirociniServletTest {

	ListaRichiesteTirociniServlet servlet = new ListaRichiesteTirociniServlet();
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
		when(session.getAttribute("username")).thenReturn("ericcson.resp");
		when(request.getServletContext()).thenReturn(servletContext);

		when(request.getServletContext().getRequestDispatcher("/ShowLista.jsp")).thenReturn(dispatcher);


		servlet.doGet(request, response);

		verify(dispatcher).forward(request, response);
	}

}
