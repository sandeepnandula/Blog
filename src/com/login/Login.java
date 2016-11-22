package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.apphosting.utils.remoteapi.RemoteApiPb.Response;

@SuppressWarnings("serial")
public class Login extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		boolean b = false;
		if (Validation.loginNullCheck(userName, password)) {
			com.google.appengine.api.datastore.DatastoreService datastore = DatastoreServiceFactory
					.getDatastoreService();

			Entity user = new Entity("UserDetails", userName);
			Key key = KeyFactory.createKey("UserDetails", userName);
			key = KeyFactory.createKey("UserDetails", userName);

			Query q = new Query("UserDetails").setAncestor(key);
			PreparedQuery pq = datastore.prepare(q);

			try {

				for (Entity user1 : pq.asIterable()) {
					if (user1.getProperty("password").equals(password)) {

						// request.getRequestDispatcher("Login.html").include(request,
						// response);
						HttpSession session = request.getSession(true);
						session.setAttribute("attribute", userName);
						response.getWriter().write("true");
						// response.sendRedirect("welcome.jsp");
						// out.println("welcome" + userName);
						// response.setStatus(3, "hello");

						// request.getRequestDispatcher("welcome.jsp").forward(request,
						// response);
					} else {
						out.println("<p>Invalid user details</p>");
					}
				}

			} catch (Exception e) {
				out.println("<p>regiser first</p>");

			}
		} else {
			// out.println("Please fill the fields");// Write response body.
			out.println("<p>Please fill the form</p>");
			// request.getRequestDispatcher("Login.html").include(request,
			// response);

		}
		out.close();
	}

}
