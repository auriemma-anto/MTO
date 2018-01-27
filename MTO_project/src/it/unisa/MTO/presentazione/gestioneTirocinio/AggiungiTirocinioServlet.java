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
import it.unisa.MTO.storage.connection.ConnessioneException;

/**
 * Servlet implementation class AggiungiTirocinioServlet
 */
@WebServlet("/AggiungiTirocinioServlet")
public class AggiungiTirocinioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiTirocinioServlet() {
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
		doGet(request, response);
		
		response.setContentType("text/html");
		HttpSession session=request.getSession(true);
		String username = (String) session.getAttribute("username");
		
		
		Tirocinio tirocinio = new Tirocinio(username,
											request.getParameter("TA"),
											request.getParameter("TE"),
											request.getParameter("azienda"),
											request.getParameter("data_inizio"),
											request.getParameter("data_fine"),
											request.getParameter("luogo"),
											request.getParameter("tematica"),
											request.getParameter("descrizione")
											);
		
		//System.out.println(tirocinio.toString());
		
		String page = "ERROR.jsp";
		try {
			Facade facade = new Facade();
			boolean res = facade.aggiungiTirocinio(tirocinio);
			
			if (res == true) {
				ArrayList<Tirocinio> lista = facade.ricercaTirociniPerParametri(ParamType.nomeResponsabileAzienda, username);
				session.setAttribute("tirocinio", lista);
				page = "view_schede.jsp";
			}else {
				page = "ERROR.jsp";
			}
		}catch (ConnessioneException e) {
			
			e.printStackTrace();
			page = "ERROR.jsp";
		}
		
		RequestDispatcher dd=request.getRequestDispatcher(page);
		dd.forward(request, response);
		
	}

}
