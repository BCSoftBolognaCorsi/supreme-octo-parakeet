package net.bcsoft.corsi.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bcsoft.corsi.dao.UtenteDao;
import net.bcsoft.corsi.models.Utente;
import net.bcsoft.corsi.service.Dto2ModelService;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("idUtente");
		Long idUtente = null;
		try {
			idUtente = Long.valueOf(id);
		}catch (Exception e) {}
		String email = request.getParameter("email");
		String nome = request.getParameter("nome");
		String eta = request.getParameter("eta");
		List<String> linguaggiList = Arrays.asList(request.getParameterValues("linguaggi"));
		
		StringBuilder requestLog = new StringBuilder("request");
		requestLog.append("\n email: {0}");
		requestLog.append("\n nome: {1}");
		requestLog.append("\n eta: {2}");
		requestLog.append("\n linguaggi: {3}");
		requestLog.append("\n id: {4}");
		
		System.out.println(MessageFormat.format(requestLog.toString(), email, nome, eta, linguaggiList,id));

		Utente utente = Dto2ModelService.createModel(id, nome, email, eta, linguaggiList);
		try {
			if(idUtente != null)
				UtenteDao.updateUtente(utente);
			else
				UtenteDao.insertUtente(utente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("utente", utente);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
