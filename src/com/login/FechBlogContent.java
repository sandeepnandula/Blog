package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;

@SuppressWarnings("serial")
public class FechBlogContent extends HttpServlet {
	@SuppressWarnings({ "deprecation", "unused" })
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		String username = request.getParameter("username");
		String title = request.getParameter("title");

		Query q = new Query("BlogContent").addFilter("Title", FilterOperator.EQUAL, title);
		PreparedQuery pq = datastore.prepare(q);
		for (Entity entity : pq.asIterable()) {

			String title1 = (String) entity.getProperty("Title");
			String heading = (String) entity.getProperty("Heading");
			String discription = (String) entity.getProperty("Discription");
			System.out.println("data is" + title1 + "heading is" + heading + "discription is" + discription);
			out.println("<h1>"+title1+  "</h1><br><h2>"+heading+  "</h2><br><p>"+discription+  "</p>  ");

		}

	}

}
