<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.RequestDispatcher"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@
 page import="com.google.appengine.api.datastore.DatastoreService"%>
<%@page
	import="com.google.appengine.api.datastore.DatastoreServiceFactory"%>
<%@page import="com.google.appengine.api.datastore.Entity"%>
<%@page import="com.google.appengine.api.datastore.PreparedQuery"%>
<%@page import="com.google.appengine.api.datastore.Query"%>
<%@page import="com.google.appengine.api.datastore.Query.FilterOperator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		// 		RequestDispatcher rd = request.getRequestDispatcher("FechBlogDetails");
		String username = request.getParameter("username");
		String title = request.getParameter("title");
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query("BlogDetails");
		PreparedQuery pq = datastore.prepare(q);
		for (Entity entity : pq.asIterable()) {
			
				String title1 = (String) entity.getProperty("Title");
				String heading = (String) entity.getProperty("Heading");
				String discription = (String) entity.getProperty("Discription");
				out.append("tittitti" + title1);
				//response.sendRedirect("");
			
		}

		// 		rd.forward(request, response);
		// 		response.getOutputStream().flush();
		// 		response.getOutputStream().close();
	%>
</body>
</html>