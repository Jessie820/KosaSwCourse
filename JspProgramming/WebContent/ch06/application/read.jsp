<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.net.*" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		read.jsp
		<hr/>
		<%
		String name1= (String)application.getAttribute("name1");
		String name2= (String)application.getAttribute("name2");
		%>
		name1 : <%=name1 %>
		name2 : <%=name2 %>
	</body>
</html>