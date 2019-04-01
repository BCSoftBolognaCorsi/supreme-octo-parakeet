package net.bcsoft.corsi.servlet;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.io.Files;

@WebServlet(urlPatterns="/sendFile")
public class SendFileServlet extends HttpServlet {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    response.setContentType("application/pdf");
    response.setStatus(HttpServletResponse.SC_OK);
    System.out.println(request.getContextPath());
    try (OutputStream out = response.getOutputStream()) {
      Files.copy(new File( request.getServletContext().getRealPath("/resources/sample.pdf") ), out);
    }
  }





}
