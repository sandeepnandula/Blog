
package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@SuppressWarnings("serial")
public class SignupServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse resp) throws IOException, ServletException {
		com.google.appengine.api.datastore.DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		String emailId = request.getParameter("emailId1");
		String userName = request.getParameter("username1");
		String password = request.getParameter("password1");
		if (Validation.SignupNullCheck(userName, password,emailId)) {

			Entity user = new Entity("UserDetails", userName);
			Key key = KeyFactory.createKey("UserDetails", userName);

			if (Validation.checkUser(key) == false) {
				user.setProperty("emailId", emailId);
				user.setProperty("userName", userName);
				user.setProperty("password", password);
				ds.put(user);
				resp.getWriter().write("true");
				
			}

			else {
				out.println("<p>User name already exits</p>");

			}
		} else {
			out.println("<p>Please fill the each form</p>");
			//request.getRequestDispatcher("Signup.html").include(request, resp);
		}
		out.close();
	}
	

}
