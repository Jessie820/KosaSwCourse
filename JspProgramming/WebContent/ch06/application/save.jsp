<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.net.*" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		save.jsp
		<hr/>
		<%
		application.setAttribute("name1", "홍길동");
		application.setAttribute("name2", "seogaram");
		/* javax.servlet.ServㅍletContext */
		/*  어떤 객체든 값에 올 수 있음!*/
		%>
		어플리케이션에 잘 저장되었습니다.
	</body>
</html>