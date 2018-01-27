package it.unisa.MTO.presentazione.account;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.MTO.storage.connection.ConnessioneException;
import it.unisa.MTO.storage.connection.exe.LoginFailedException;
import it.unisa.MTO.businessLogic.Facade;
import it.unisa.MTO.common.UtenteType;

/**
 * Servlet implementation class LoginServlet
 * 
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		HttpSession session=request.getSession(true);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String page = "";
		
		try {
			Facade facade = new Facade();
			if(facade.login(username, password) == true) {
			
				session.setAttribute("username", username);
				
				String tipo = facade.getTipo(username, password);
				session.setAttribute("tipo", tipo);
			
			session.setMaxInactiveInterval(60*5);
			 
		//	out.println(Response.OK.getValue());
			System.out.println(tipo);
			
			if(tipo.equals("Studente")) {
				//out.println(Response.OK.getValue());
				System.out.println(1);
				page = "studente.jsp";
				
			}else if(tipo.equals("Responsabile Azienda")) {
				//out.println(Response.OK.getValue());
				System.out.println(2);
				page = "responsabileAzienda.jsp";
			}else if(tipo.equals("Tutor Esterno")) {
				//out.println(Response.OK.getValue());
				System.out.println(3);
				page = "tutorEsterno.jsp";
			}else if(tipo.equals("Tutor Interno")) {
				//out.println(Response.OK.getValue());
				System.out.println(4);
				page = "tutorAccademico.jsp";
			}
			
			} else {
				page = "ERROR_Login.jsp";
			}
			
		}catch (ConnessioneException e) {
			page = "ERROR.jsp";
		}
	
		RequestDispatcher dd=request.getRequestDispatcher(page);
		dd.forward(request, response);
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
			
			
			
