package it.unisa.MTO.presentazione.account;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	Utente utente = new Utente(request.getParameter("username"),
								   request.getParameter("password"), 
								   request.getParameter("email"),
 /*converte la stringa nell'enumerazione*/  UtenteType.valueOf(request.getParameter("tipo")),
								   request.getParameter("nome"),
								   request.getParameter("cognome"),
								   request.getParameter("dataNascita"),
								   request.getParameter("annoImmatricolazione"),
								   Integer.parseInt(request.getParameter("cfu")),
								   request.getParameter("universita"),
								   request.getParameter("dipartimento"));
	
	
	Response result = Response.KO;
	String description = "Username già presente";
    JSONObject json = new JSONObject();
	Facade facade = new Facade();

	try {
		facade.registrazione(utente);
	} catch (ConnessioneException e) {
		result = Response.KO;
		description = e.getMessage();
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
