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

/**
 * Servlet implementation class VisualizzaRichiestaServlet
 */
@WebServlet("/VisualizzaRichiestaServlet")
public class VisualizzaRichiestaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public boolean checkF;

	public VisualizzaRichiestaServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Il get dell'username deve venire alla sessione
		String username = request.getParameter("username");
		Integer tirocinio = Integer.parseInt(request.getParameter("tirocinio"));
		String docName = "progettoformativo_"+username+".pdf";
		
		ServletContext context = getServletContext();
		
		//setta il mime type per il download dei file
		String mimeType = context.getMimeType(docName);
		if (mimeType == null) {
			mimeType = "application/octet-stream";
		}
		
		//settare le proprietà del content e gli attributi dell'header per la response
		
		response.setContentType(mimeType);
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; fileName=\"%s\"", docName);
		response.setHeader(headerKey,  headerValue);
		
		OutputStream outStream = response.getOutputStream();
		
		Facade f = new Facade();
		checkF = f.getDomandaRichiesta(outStream, username, docName, tirocinio);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
