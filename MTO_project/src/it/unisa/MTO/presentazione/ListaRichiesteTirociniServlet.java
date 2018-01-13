package it.unisa.MTO.presentazione;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.MTO.businessLogic.Facade;
import it.unisa.MTO.common.DocumentoRichiesta;
import it.unisa.MTO.common.Tirocinio;

/**
 * Servlet implementation class ListaRichiesteTirociniServlet
 */
@WebServlet("/listaRichieste")
public class ListaRichiesteTirociniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Tirocinio tirocinio = new Tirocinio();
		tirocinio.setCodiceID(12);

		Facade f = new Facade();
		ArrayList<DocumentoRichiesta> docs = f.listaDomandeRichiesta(tirocinio);

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
