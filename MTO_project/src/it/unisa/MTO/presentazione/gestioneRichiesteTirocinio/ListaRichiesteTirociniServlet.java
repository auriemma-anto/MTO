package it.unisa.MTO.presentazione.gestioneRichiesteTirocinio;

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
import it.unisa.MTO.common.Utente;

/**
 * La servlet che permette di ottenere la lista dei progetti formativi 
 */

@WebServlet("/listaRichieste")
public class ListaRichiesteTirociniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Utente user = new Utente();
		user.setUsername((String) request.getSession().getAttribute("username"));
		Facade f = new Facade();
		ArrayList<DocumentoRichiesta> docs = f.listaDomandeRichiesta(user);
		Iterator<?> it = docs.iterator();
		System.out.println("DOCSIZE: " + docs.size());


		while(it.hasNext()){
			DocumentoRichiesta d = f.statoDomandaRichiesta((DocumentoRichiesta) it.next());
			for(int i=0; i<d.getFirma().size(); i++){
				if(d.getFirma().get(i).getUtente().getUsername().equals(user.getUsername())){
					it.remove();
				}
			}
		}

		request.removeAttribute("documenti");
		request.setAttribute("documenti", docs);

		for(int i=0; i<docs.size(); i++){
			System.out.println("Servlet: "+docs.get(i).getCodiceID());
			System.out.println("Servlet: "+docs.get(i).getNome());
			System.out.println("Servlet: "+docs.get(i).getStudente().getUsername());
			System.out.println("Servlet: "+docs.get(i).getTirocinio().getCodiceID());
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ShowLista.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
