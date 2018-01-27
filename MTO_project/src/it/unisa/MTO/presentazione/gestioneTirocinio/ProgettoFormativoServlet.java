package it.unisa.MTO.presentazione.gestioneTirocinio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProgettoFormativoServlet
 */
@WebServlet("/ProgettoFormativoServlet")
public class ProgettoFormativoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProgettoFormativoServlet() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String path = getServletContext().getRealPath("document/progetto_formativo.pdf");
		
		response.setContentType("APPLICATION/PDF");
		response.setHeader("Scarica: ", "ProgettoForamtivo");
		
		FileInputStream file = new FileInputStream(path);
		int i;
		while((i = file.read()) != -1)
			out.write(i);
		
		file.close();
		out.close();
		
		
	}

}
