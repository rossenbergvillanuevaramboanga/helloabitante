package it.helloabitante.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.helloabitante.dao.DB_Mock;
import it.helloabitante.model.Abitante;
import it.helloabitante.service.MyServiceFactory;
import it.helloabitante.service.abitante.AbitanteService;
import jdk.jshell.Diag;

/**
 * Servlet implementation class CreaAbitanteServlet
 */
@WebServlet("/ExecuteCreaAbitanteServlet")
public class ExecuteCreaAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExecuteCreaAbitanteServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String destinazione = "createAbitante.jsp";

		AbitanteService abitanteServiceInstance = MyServiceFactory.getAbitanteServiceInstance();

		// Binding
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String codiceFiscale = request.getParameter("codicefiscale");
		String eta = request.getParameter("eta");
		String mottoDiVita = request.getParameter("mottodivita");

		if (nome.isBlank() || cognome.isBlank() || codiceFiscale.isBlank() || eta.isBlank() || mottoDiVita.isBlank()) {
			String messaggioErrore = "Inserire tutti i campi";
			request.setAttribute("messaggioErrore", messaggioErrore);
			request.getRequestDispatcher(destinazione).forward(request, response);
			return;
		}

		Abitante abitante = new Abitante(null, nome, cognome, codiceFiscale, Integer.parseInt(eta), mottoDiVita);
		
		try {
			
			abitanteServiceInstance.inserisciSingolo(abitante);
			request.setAttribute("listAbitantiAttributeName", abitanteServiceInstance.elencaTutti());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		destinazione = "results.jsp";
		String messaggioCreazione = "Abitante Inserito Nel DB";
		request.setAttribute("messaggioCreazione", messaggioCreazione);
		request.getRequestDispatcher(destinazione).forward(request, response);

	}

}
