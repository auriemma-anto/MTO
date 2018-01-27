package it.unisa.MTO.presentazione.gestioneTirocinio;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.MTO.businessLogic.Facade;
import it.unisa.MTO.common.ParamType;
import it.unisa.MTO.common.Tirocinio;
import it.unisa.MTO.common.UtenteType;
import it.unisa.MTO.storage.connection.ConnessioneException;

/**
 * Servlet implementation class VisualizzaListaTirocini
 */
@WebServlet("/ListaTirociniServlet")
public class ListaTirociniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaTirociniServlet() {
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
		HttpSession session=request.getSession(true);
		String username = (String) session.getAttribute("username");
		String tipo = (String) session.getAttribute("tipo");
		
		String page = "ERROR.jsp";
		try {
			if (tipo.equals("Responsabile Azienda")) {
			Facade facade = new Facade();
			ArrayList<Tirocinio> lista = facade.ricercaTirociniPerParametri(ParamType.nomeResponsabileAzienda, username);
			session.setAttribute("tirocinio", lista);
			page = "view_schede.jsp";
			}/*else {
				page = "ERROR.jsp";
			}*/
		} catch (ConnessioneException e) {
			e.printStackTrace();
			
			page = "ERROR.jsp";
		}
		
		RequestDispatcher dd=request.getRequestDispatcher(page);
		dd.forward(request, response);
	
	}

}
