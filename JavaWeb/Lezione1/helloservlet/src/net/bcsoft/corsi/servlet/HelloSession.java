package net.bcsoft.corsi.servlet;

import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HelloSession
 */
@WebServlet("/HelloSession")
public class HelloSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder responseMessage = new StringBuilder("<h1> {0} : Hello Web  </h1>");
		responseMessage.append("<p> tentativi {1} </p>");
		String name = request.getParameter("name");
		
		// request.getSession(true) inizializza una sessione se questa ancora non esiste
		HttpSession session = request.getSession(true);
		
		// cerchiamo l'init-parameter 'nomeDefault' definito nel web.xml per questa servlet
		ServletConfig servletConfig = this.getServletConfig();
		String nomeDefault = servletConfig.getInitParameter("nomeDefault");
		
		Object tentativi =  session.getAttribute("tantativi");
		Integer tentativiNumber = null;
		if(tentativi == null) {
			session.setAttribute("tantativi", 1);
			tentativiNumber = 1;
		} else {
			session.setAttribute("tantativi", (Integer) tentativi +1);
			tentativiNumber = (Integer) tentativi +1;
		}
		response.getWriter().append(MessageFormat.format(responseMessage.toString(), name != null ? name : nomeDefault, tentativiNumber));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
