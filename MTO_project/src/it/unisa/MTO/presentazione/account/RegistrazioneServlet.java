package it.unisa.MTO.presentazione.account;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import it.unisa.MTO.businessLogic.Facade;
import it.unisa.MTO.common.Utente;
import it.unisa.MTO.common.UtenteType;
import it.unisa.MTO.storage.connection.ConnessioneException;

/**
 * Servlet implementation class RegistrazioneServlet
 */
@WebServlet("/RegistrazioneServlet")
public class RegistrazioneServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrazioneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter(); 
		
		Utente utente = new Utente(request.getParameter("username"),
								   request.getParameter("password"), 
								   request.getParameter("email") + "@studenti.unisa.it",
 /*imposta il tipo studente*/      UtenteType.studente,
								   request.getParameter("nome"),
								   request.getParameter("cognome"),
								   request.getParameter("dataNascita"),
								   request.getParameter("annoI1") + "/" + request.getParameter("annoI2"),
								   Integer.parseInt(request.getParameter("cfu")),
								   request.getParameter("universita"),
								   request.getParameter("dipartimento"));
	
	//System.out.println("Reg"+utente.toString());	
	
	Response result = Response.KO;
	String description;
	if(utente.getUsername() !=null){
		description = "Username esistente!";
	}else{
		description = "i campi non sono inseriti correttamente!";
	}
	JSONObject json = new JSONObject();
	
	

	try {
		Facade facade = new Facade();
		if (facade.registrazione(utente) == true) {
			result = Response.OK;
			description = null;
			//response.sendRedirect("login.jsp");
		} 
		
	} catch (ConnessioneException e) {
		result = Response.KO;
		description = e.getMessage();
	}
	try {
		json.put("result", result.getValue());
		json.put("description", description);
    	out.print(json.toString());
    	out.close();
	} catch (JSONException e) {
		throw new ServletException("Fallimento");
		
	}        

	
	}
	
	enum Response {
		OK(1),KO(0);
		
		private int value;

		private Response(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
	}
}
