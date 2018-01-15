package it.unisa.MTO.presentazione;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.MTO.businessLogic.Facade;
import it.unisa.MTO.common.DocumentoRichiesta;
import it.unisa.MTO.common.Firma;
import it.unisa.MTO.common.Tirocinio;
import it.unisa.MTO.common.Utente;

/**
 * Servlet implementation class VisualizzaStatoRichiestaServlet
 */
@WebServlet("/visualizzaStato")
public class VisualizzaStatoRichiestaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// l'utente deve essere passato dalla sessione
		Utente user = new Utente();
		user.setUsername("r.napo12");

		Facade f = new Facade();

		ArrayList<DocumentoRichiesta> documenti = f.listaDomandeRichiesta(new Tirocinio(), user);
		Iterator<?> it = documenti.iterator();
		ArrayList<DocumentoRichiesta> docFirmati = new ArrayList<DocumentoRichiesta>();		
		
		while(it.hasNext()){
			DocumentoRichiesta doc = (DocumentoRichiesta) it.next();
			ArrayList<Firma> listaFirme = f.statoDomandaRichiesta(doc).getFirma();			

			doc.setFirma(listaFirme);
			docFirmati.add(doc);
		}

		request.removeAttribute("documenti");
		request.setAttribute("documenti", docFirmati);	

		RequestDispatcher redispatcher = getServletContext().getRequestDispatcher("/ShowStatoDocumento.jsp");
		redispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
