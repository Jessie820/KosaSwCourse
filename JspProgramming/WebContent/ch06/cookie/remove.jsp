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
		Cookie cookie1 = new Cookie("name1", "");
		Cookie cookie2 = new Cookie("name2", "");
		
		cookie1.setMaxAge(0);
		cookie2.setMaxAge(0);
		/* MaxAge는 쿠키가 저장될 수 있는 시간을 의미->즉 쿠키를 없애라 */
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		%>
		쿠키를 삭제했습니다.
	</body>
</html>