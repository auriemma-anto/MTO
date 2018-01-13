package it.unisa.MTO.presentazione;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.MTO.businessLogic.Facade;
import it.unisa.MTO.common.DocumentoRichiesta;
import it.unisa.MTO.common.Utente;

@WebServlet("/firmaRichiesta")
public class FirmaRichiestaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	DocumentoRichiesta documento = new DocumentoRichiesta();
    	documento.setCodiceID(9);
    	
    	boolean[] firme = new boolean[4];
		firme[0] = Boolean.parseBoolean(request.getParameter("firma1"));
		firme[1] = Boolean.parseBoolean(request.getParameter("firma2"));
		firme[2] = Boolean.parseBoolean(request.getParameter("firma3"));
		firme[3] = Boolean.parseBoolean(request.getParameter("firma4"));
		
		Utente u1 = new Utente();
		u1.setUsername(request.getParameter("username1"));
		Utente u2 = new Utente();
		u2.setUsername(request.getParameter("username2"));
		Utente u3 = new Utente();
		u3.setUsername(request.getParameter("username3"));
		Utente u4 = new Utente();
		u4.setUsername(request.getParameter("username4"));
		
		Facade f1 = new Facade();
		Facade f2 = new Facade();
		Facade f3 = new Facade();
		Facade f4 = new Facade();
		
		f1.firmaDomandaRichiesta(documento, u1, firme[0]);
		f2.firmaDomandaRichiesta(documento, u2, firme[1]);
		f3.firmaDomandaRichiesta(documento, u3, firme[2]);
		f4.firmaDomandaRichiesta(documento, u4, firme[3]);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Firme.jsp");
		dispatcher.forward(request, response);	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
