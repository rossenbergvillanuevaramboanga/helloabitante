package it.helloabitante.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.helloabitante.service.MyServiceFactory;
import it.helloabitante.service.abitante.AbitanteService;
import it.helloabitante.model.Abitante;

/**
 * Servlet implementation class EliminaAbitanteServlet
 */
@WebServlet("/ExecuteEliminaAbitanteServlet")
public class ExecuteEliminaAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExecuteEliminaAbitanteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AbitanteService abitanteServiceInstance = MyServiceFactory.getAbitanteServiceInstance();

		Long idAbitante = Long.parseLong(request.getParameter("idDaInviareComeParametro"));
		
		
		try {
			Abitante abitante = abitanteServiceInstance.caricaSingolo(idAbitante);
			abitanteServiceInstance.eliminaSingolo(abitante);
			request.setAttribute("listAbitantiAttributeName", abitanteServiceInstance.elencaTutti());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("results.jsp").forward(request, response);
		
	
	}

}
