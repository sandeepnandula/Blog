package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;

@SuppressWarnings("serial")
public class FechBlogDetails extends HttpServlet {
	@SuppressWarnings({ "deprecation", "unused" })
	public void doPost(HttpServletResponse response, HttpServletRequest request) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String title = request.getParameter("title");
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query("UserDetails").addFilter("Title", FilterOperator.EQUAL, title);
		PreparedQuery pq = datastore.prepare(q);
		for (Entity entity : pq.asIterable()) {
			if (entity.getProperty("username").equals(username)) {
				String title1 = (String) entity.getProperty("Title");
				String heading = (String) entity.getProperty("Heading");
				String discription = (String) entity.getProperty("Discription");
				out.println("<h1" + title1 + "<h1>");

			}
		}

	}

}
