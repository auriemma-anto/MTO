package it.unisa.MTO.presentazione;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.MTO.businessLogic.Facade;
import it.unisa.MTO.common.DocumentoRichiesta;
import it.unisa.MTO.common.Tirocinio;
import it.unisa.MTO.common.Utente;

/**
 * Servlet implementation class VisualizzaRichiestaServlet
 */
@WebServlet("/downloadServlet")
public class VisualizzaRichiestaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public boolean checkF;

	public VisualizzaRichiestaServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utente studente = new Utente();
		studente.setUsername(request.getParameter("username"));

		Tirocinio tirocinio = new Tirocinio();
		tirocinio.setCodiceID(Integer.parseInt(request.getParameter("tirocinio")));

		DocumentoRichiesta documento = new DocumentoRichiesta();

		documento.setStudente(studente);
		documento.setTirocinio(tirocinio);
		documento.setNome("pf_"+studente.getUsername()+".pdf");

		System.out.println(""+documento.getStudente().toString());
		System.out.println(""+documento.getNome());
		System.out.println(""+documento.getTirocinio().toString());

		ServletContext context = getServletContext();

		//setta il mime type per il download dei file
		String mimeType = context.getMimeType(documento.getNome());
		if (mimeType == null) {
			mimeType = "application/octet-stream";
		}

		//settare le proprietà del content e gli attributi dell'header per la response

		response.setContentType(mimeType);
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; fileName=\"%s\"", documento.getNome());
		response.setHeader(headerKey,  headerValue);

		OutputStream outStream = response.getOutputStream();

		Facade f = new Facade();
		checkF = f.getDomandaRichiesta(documento, outStream);
	}

}
