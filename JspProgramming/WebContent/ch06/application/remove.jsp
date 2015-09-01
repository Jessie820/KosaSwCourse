<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<metacharset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		remove.jsp
		<hr/>
		<%
		application.removeAttribute("name1");
		application.removeAttribute("name2");
		%>
		어플리케이션에서 삭제했습니다.
	</body>
</html>