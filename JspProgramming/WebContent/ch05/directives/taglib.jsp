<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- taglib는 HTML에서 없는 태그를 쓰기 위해 쓰는 것 -->
<!-- jstl-1.2.jar여기에 있는 태그 -->

<%
	List<String> list = new ArrayList<String>();
	list.add("나의");
	list.add("인생");
	list.add("성공기");
	session.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		<ul>
		<%
		List<String> list2 = (List<String>)session.getAttribute("list");
		for(String str : list2){%>
			<li><%=str %></li>
		<%} %>
		</ul>
		
		<hr/>
		
		<ul>
			<c:forEach var="str" items="${list}">
			<!-- forEach는 반복문 ${list}에 있는 값을 하나씩 꺼내오겠다. -->
				<li>${str}</li><!-- ${str}요렇게 써줘야 함 -->
				</c:forEach>
		</ul>
		

	</body>
</html>