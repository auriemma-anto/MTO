package it.unisa.MTO.presentazione;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import it.unisa.MTO.businessLogic.Facade;
import it.unisa.MTO.common.DocumentoRichiesta;
import it.unisa.MTO.common.Tirocinio;
import it.unisa.MTO.common.Utente;

/**
 * Servlet implementation class AggiungiRichiestaServlet
 */
@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)
public class AggiungiRichiestaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// gets values of text fields
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

		InputStream inputStream = null;	// input stream of the upload file

		// obtains the upload file part in this multipart request
		Part filePart = request.getPart("documento");
		if (filePart != null) {
			// prints out some information for debugging
			System.out.println(filePart.getName());
			System.out.println(filePart.getSize());
			System.out.println(filePart.getContentType());

			// obtains input stream of the upload file
			inputStream = filePart.getInputStream();
			documento.setFile(inputStream);
		}
		
		
		Facade f = new Facade();
		boolean res = f.aggiungiDomandaRichiesta(documento);

		System.out.println(res);

		inputStream.close();
		
		RequestDispatcher redispatcher = getServletContext().getRequestDispatcher("/UploadDemo.jsp");
		redispatcher.forward(request, response);

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
