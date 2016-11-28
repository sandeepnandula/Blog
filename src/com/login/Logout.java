package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class Logout extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(false);
		if (session != null) {
			// response.getWriter().println("session is logout");

			session.invalidate();

			// session.setMaxInactiveInterval(0); // The session will end in the
			// 30

			response.sendRedirect("Index.jsp");
		}
		// else {
		// out.println("You Logout sucessfully");
		// request.getRequestDispatcher("index.html").include(request,
		// response);
		// }

	}
}
