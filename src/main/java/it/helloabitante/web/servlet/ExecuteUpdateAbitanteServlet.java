package it.helloabitante.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.helloabitante.model.Abitante;
import it.helloabitante.service.MyServiceFactory;
import it.helloabitante.service.abitante.AbitanteService;

/**
 * Servlet implementation class ExecuteUpdateAbitanteServlet
 */
@WebServlet("/ExecuteUpdateAbitanteServlet")
public class ExecuteUpdateAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteUpdateAbitanteServlet() {
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
		//Fare qualcosa
		String destinazione = "update.jsp";

		AbitanteService abitanteServiceInstance = MyServiceFactory.getAbitanteServiceInstance();

		// Binding
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String codiceFiscale = request.getParameter("codicefiscale");
		String eta = request.getParameter("eta");
		String mottoDiVita = request.getParameter("mottodivita");
		
		Abitante abitante = new Abitante(Long.parseLong(id), nome, cognome, codiceFiscale, Integer.parseInt(eta), mottoDiVita);

		if (nome.isBlank() || cognome.isBlank() || codiceFiscale.isBlank() || eta.isBlank() || mottoDiVita.isBlank()) {
			String messaggioErrore = "Inserire tutti i campi";
			request.setAttribute("messaggioErrore", messaggioErrore);
			request.setAttribute("abitanteDaModificare", abitante);
			request.getRequestDispatcher(destinazione).forward(request, response);
			return;
		}
		
		try {
			abitanteServiceInstance.aggiornaSingolo(abitante);
			String messaggioAggiorna = "Abitante Aggiornato Nel DB";
			request.setAttribute("messaggioCreazione", messaggioAggiorna);
			request.setAttribute("listAbitantiAttributeName", abitanteServiceInstance.elencaTutti());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		destinazione = "results.jsp";
		request.getRequestDispatcher(destinazione).forward(request, response);
		
	}

}
