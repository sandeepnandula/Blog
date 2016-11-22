<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/Css/WelcomeStyleSheet.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script type="text/javascript" language="javascript" src="/Js/MyJs.js">
	
</script>

<title>Welcome</title>
</head>


<body>
<P id="status"></P>

	<%
	
	
	if (session.getAttribute("attribute") != null) {
		String name = (String) session.getAttribute("attribute");
		out.print("welcome " + name);
		out.print("<br><input type=\"button\" value=\"logout\" id=\"Logout\"/>");
	} 
	else if (session.getAttribute("attribute") == null) {
		out.print("<div><p id=\"usertext\">WELCOME</p><button id=\"usersignup\" class=\"user\">SignUp</button><br><button id=\"userlogin\" class=\"user\">SignIn</button></div>");
	}
%>


</body>
</html>
