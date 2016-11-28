<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.google.appengine.api.datastore.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/Css/WelcomeStyleSheet.css">
<link rel="icon" href="data:;base64,=">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script type="text/javascript" language="javascript"
	src="/Js/CommonJs.js">
	
</script>

<title>Welcome</title>
</head>


<body>
	<div id="bg">


		<P id="status"></P>

		<%
			if (session.getAttribute("attribute") != null) {
				// 			String name = (String) session.getAttribute("attribute");
				// 			out.print("welcome " + name);

				out.print(
						"<div id=\"welcomecontent\"><p id=\"usertext\">WELCOME</p><button id=\"blogformbtn\" class=\"user\">Create</button><br><br><button id=\"Logout\" class=\"user\">Logout</button></div>");

			} else if (session.getAttribute("attribute") == null) {
				out.print(
						"<div id=\"welcomecontent\"><p id=\"usertext\">WELCOME</p><button id=\"usersignup\" class=\"user\">SignUp</button><br><br><button id=\"userlogin\" class=\"user\">SignIn</button></div>");
			}
		%>
		<marquee>
			<p id="attribute">
				<%
					if (session.getAttribute("attribute") != null) {
						String name = (String) session.getAttribute("attribute");
						out.print("Hi!" + name);
					}
				%>
			</p>
		</marquee>
		<div id="blogdetails"></div>
		<p id="test"></p>
		<div hidden id="blogform">
			<table>

				<tr>
					<td>
						<p>Title:</p> <input type="text" id="blogtitle"
						placeholder="Title for your blog"
						title="Enter your your blogtitle" size="31" class="textf">
					</td>
				</tr>

				<tr>

					<td>
						<p>Heading of your blog:</p> <input type="text" id="blogheading"
						placeholder="Heading..." title="Enter your password here"
						size="31" class="textf">
					</td>
				</tr>


				<tr>

					<td><p>Discription:</p> <textarea cols="35" rows="5"
							style="overflow: auto;" id="blogdiscription"
							title="Enter you discription" size="31" class="textf"></textarea></td>
				</tr>
				<tr>
					<td><button id="blogcreatebtn">Create</button></td>
				</tr>
			</table>

		</div>
	</div>
</body>
</html>
