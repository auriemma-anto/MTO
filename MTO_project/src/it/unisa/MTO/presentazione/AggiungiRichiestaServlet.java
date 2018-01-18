package it.unisa.MTO.presentazione;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import it.unisa.MTO.businessLogic.Facade;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/uploadServlet")
public class AggiungiRichiestaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public boolean checkF;
	
	public AggiungiRichiestaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Il get dell'username deve venire alla sessione
		String username = request.getParameter("username");
		Integer tirocinio = Integer.parseInt(request.getParameter("tirocinio"));
		String docName = "progettoformativo_"+username+".pdf";
		
		InputStream inputStream = null;	// input stream of the upload file
		
		// obtains the upload file part in this multipart request
		Part filePart = request.getPart("doc");
		if (filePart != null) {
			// prints out some information for debugging
			System.out.println(filePart.getName());
			System.out.println(filePart.getSize());
			System.out.println(filePart.getContentType());
			
			// obtains input stream of the upload file
			inputStream = filePart.getInputStream();
		}
		
		Facade f = new Facade();
		checkF = f.aggiungiDomandaRichiesta(username, docName, tirocinio, inputStream);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
