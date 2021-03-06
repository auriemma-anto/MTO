package it.unisa.MTO.presentazione.gestioneRichiesteTirocinio;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.MTO.businessLogic.Facade;
import it.unisa.MTO.common.DocumentoRichiesta;
import it.unisa.MTO.common.Utente;

/**
 * 
 * La servlet che permette di apportare una firma ad un progetto formativo
 *
 */

@WebServlet("/firmaRichiesta")
public class FirmaRichiestaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public FirmaRichiestaServlet() {
		super();
	}
	
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean firma = Boolean.parseBoolean(request.getParameter("firma"));

		Utente user = new Utente();
		user.setUsername(request.getParameter("username"));


		DocumentoRichiesta documento = new DocumentoRichiesta();
		documento.setCodiceID(Integer.parseInt(request.getParameter("documento")));

		Facade f1 = new Facade();

		documento = f1.statoDomandaRichiesta(documento);	

		f1.firmaDomandaRichiesta(documento, user, firma);

		ServletContext context = request.getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/ShowLista.jsp");
		dispatcher.forward(request, response);	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
