package com.Hans.Curd.Project.FirstPage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainPage
 */
@WebServlet("/MainPage")
public class MainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("useremail");
		String password = request.getParameter("userpassword");
		
		if(email.equalsIgnoreCase("admin") && password.equals("admin")) {
			response.sendRedirect("./Menu.html");
		}else {
			response.sendRedirect("./index.html");
		}
	}

}
