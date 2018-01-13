package it.unisa.MTO.presentazione;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.MTO.businessLogic.Facade;
import it.unisa.MTO.common.DocumentoRichiesta;
import it.unisa.MTO.common.Firma;

/**
 * Servlet implementation class VisualizzaStatoRichiestaServlet
 */
@WebServlet("/visualizzaStato")
public class VisualizzaStatoRichiestaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaStatoRichiestaServlet() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DocumentoRichiesta doc = new DocumentoRichiesta();
		doc.setCodiceID(Integer.parseInt(request.getParameter("codice")));
		
		System.out.println(doc.getCodiceID());
		
		Facade f = new Facade();
		doc = f.statoDomandaRichiesta(doc);
		
		ArrayList<Firma> listaFirme= doc.getFirma();
		
		System.out.println(listaFirme.get(0).getValore() + " " + listaFirme.get(0).getUtente().getUsername());
		System.out.println(listaFirme.get(1).getValore() + " " + listaFirme.get(1).getUtente().getUsername());
		System.out.println(listaFirme.get(2).getValore() + " " + listaFirme.get(2).getUtente().getUsername());
		System.out.println(listaFirme.get(3).getValore() + " " + listaFirme.get(3).getUtente().getUsername());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
