package net.bcsoft.corsi.servlet;

import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloParameters
 */
@WebServlet("/HelloParameters")
public class HelloParameters extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet " + this.getServletName() + " has started at : " + LocalDateTime.now() );
	}
	
	@Override
	public void destroy() {
		System.out.println("Servlet " + this.getServletName() + " has stopped at: " + LocalDateTime.now());
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloParameters() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder responseMessage = new StringBuilder("<h1> {0} : Hello Web  </h1>");
		String name = request.getParameter("name");
		

		response.getWriter().append(MessageFormat.format(responseMessage.toString(), name));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
