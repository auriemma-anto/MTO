package it.unisa.MTO.presentazione;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import it.unisa.MTO.businessLogic.Facade;

/**
 * Servlet implementation class AggiungiRichiestaServlet
 */
@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)
public class AggiungiRichiestaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private boolean checkF;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
	    String docName = "progettoformativo_"+username+".pdf";
	    Integer tirocinio = Integer.parseInt(request.getParameter("tirocinio"));
	    
	    InputStream inputStream = null;  // input stream of the upload file
	    
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
		
		getServletContext().getRequestDispatcher("/DownloadDemo.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
