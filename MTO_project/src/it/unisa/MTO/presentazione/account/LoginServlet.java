package it.unisa.MTO.presentazione.account;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Login.Response;
import it.unisa.MTO.storage.connection.ConnessioneException;
import it.unisa.MTO.storage.connection.exe.LoginFailedException;
import it.unisa.MTO.businessLogic.Facade;

/**
 * Servlet implementation class LoginServlet
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
		
		
		try {
			Facade facade = new Facade();
			facade.login(username, password);
			String nome = (String) session.getAttribute("nome");
			String tipo = (String) session.getAttribute("tipo");
			
			session.setMaxInactiveInterval(60*5);
			
			out.println(Response.OK.getValue());

			
			
			
			out.println(Response.OK.getValue());
		} catch (LoginFailedException e) {
			out.println(Response.KO.getValue());
		} catch (SQLException e) {
			out.println(Response.KO.getValue());
		} catch (ConnessioneException e) {
			out.println(Response.KO.getValue());
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
