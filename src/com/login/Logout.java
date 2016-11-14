package com.login;

import java.io.IOException;
import java.util.concurrent.Delayed;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class Logout extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		response.getWriter().println("session is logout");

		HttpSession session = request.getSession(true);
		if (session != null) {
			session.setMaxInactiveInterval(0); // The session will end in the 30
												// sec
			response.sendRedirect("index.html");
		}
	}
}
