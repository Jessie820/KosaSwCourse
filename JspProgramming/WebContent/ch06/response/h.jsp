<%@ page contentType="text/html; charset=UTF-8"%>

<%
String username = request.getParameter("username");
int age = Integer.parseInt(request.getParameter("age"));
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		h.jsp
		<hr/>
		username: <%=username %>
		age: <%=age %>
	</body>
</html>