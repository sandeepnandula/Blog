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

@SuppressWarnings("serial")
public class Login extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		com.google.appengine.api.datastore.DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Entity user = new Entity("UserDetails", userName);
		Key key = KeyFactory.createKey("UserDetails", userName);
		key = KeyFactory.createKey("UserDetails", userName);
		Query q = new Query("UserDetails").setAncestor(key);
		PreparedQuery pq = datastore.prepare(q);
		try {

			for (Entity user1 : pq.asIterable()) {
				user1.getProperty("password").equals(password);
				out.println("welcome");
				out.println("<form action='Logout' method='get'><type='submit' value='Logout'></form>");
				HttpSession session = request.getSession(true);

			}
		} catch (Exception e) {
			out.println("regiser first");
		}

	}
}
