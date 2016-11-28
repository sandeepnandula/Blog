package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tools.ant.types.resources.selectors.Date;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.DatastoreTimeoutException;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

import com.sun.xml.internal.fastinfoset.util.QualifiedNameArray;

@SuppressWarnings("serial")
public class BlogCreation extends HttpServlet {
	@SuppressWarnings({})
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String title = request.getParameter("title");
		String heading = request.getParameter("heading");
		String discription = request.getParameter("discription");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		long time = timestamp.getTime();

		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

		HttpSession session = request.getSession();
		if (session.getAttribute("attribute") != null) {
			String username = (String) session.getAttribute("attribute");
			Entity BlogContent = new Entity("BlogContent");

			BlogContent.setProperty("Title", title);
			BlogContent.setProperty("Heading", heading);
			BlogContent.setProperty("Discription", discription);
			BlogContent.setProperty("UserName", username);
			BlogContent.setProperty("TimeOfCreation", time);
			datastore.put(BlogContent);
			out.print("updated");

			request.getRequestDispatcher("Index.jsp").include(request, response);
		} else {
			out.println("you are not loged-In");
		}

	}

}
// ArrayList<String> title1 = (ArrayList<String>)
// user.getProperty("Title");
// title1.add(title);
// ArrayList<String> heading1 = (ArrayList<String>)
// user.getProperty("Heading");
// heading1.add(heading);
// ArrayList<String> discription1 = (ArrayList<String>)
// user.getProperty("Discription");
// discription1.add(discription);
// Query q = new Query("UserDetails");
// PreparedQuery pq = datastore.prepare(q);
// for (Entity e : pq.asIterable()) {
// ArrayList<String> list = (ArrayList<String>)
// e.getProperty("Title");
// for (String str : list) {
// System.out.println(str);
// }
// }
