<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.net.*" %><!--  -->

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
		String name1= URLEncoder.encode("나경쓰", "UTF-8");
		System.out.println(name1);
		/*쿠키는 헤더행에 실려서 넘어감  */
		Cookie cookie1 = new Cookie("name1", name1);
		response.addCookie(cookie1);
		/* 요렇게만 하면 메모리에만 저장되고 */
		
		Cookie cookie2 = new Cookie("name2", "seogaram");
		cookie2.setMaxAge(365*24*60*60);
		response.addCookie(cookie2);
		/* 요렇게 하면 하드디스크에도 저장. 브라우저가 닫혀도 하드에 저장되어 있으니까 다음에 다시 열어도 
		쿠키가 실행됨.
		*/
		
		%>
		쿠키가 잘 저장되었습니다.
	</body>
</html>