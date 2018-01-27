package it.unisa.MTO.presentazione.gestioneTirocinio;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class EliminaListaTirocinioServlet
 */
@WebServlet("/EliminaListaTirocinioServlet")
public class EliminaListaTirocinioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaListaTirocinioServlet() {
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
		
		int codiceTirocinio = Integer.parseInt(request.getParameter("codiceTirocinio"));
		
		System.out.println("usernam=" +username);
		System.out.println("codice=" +codiceTirocinio);
		
		try {
			Facade facade = new Facade();
			
			boolean res = facade.eliminaTirocinio(codiceTirocinio);
			
			
			if (res == true ) {
				ArrayList<Tirocinio> lista = facade.ricercaTirociniPerParametri(ParamType.nomeResponsabileAzienda, username);
				session.setAttribute("tirocinio", lista);
				response.sendRedirect("view_schede.jsp");
			}else {
				response.sendRedirect("ERROR.jsp");
			}
			
		}catch(ConnessioneException e){
			e.printStackTrace();
			response.sendRedirect("ERROR.jsp");
		}
		
	}

}
