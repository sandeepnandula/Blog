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

@SuppressWarnings("serial")
public class BlogDetails extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query("BlogContent");
		PreparedQuery pq = datastore.prepare(q);
		for (Entity e : pq.asIterable()) {
			String username = e.getProperty("UserName").toString();
			String title = e.getProperty("Title").toString();
			out.print("<button class=\"bloglink\"  id=\"" + title + "\" value=\" " + username
					+ "\">View</button> <p>Username:--</p>" + username + "BLOGTITLE :---" + title + "<br />");
		}

	}
}
