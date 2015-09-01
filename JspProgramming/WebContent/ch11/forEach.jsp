<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="java.util.*" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		forEach.jsp
		<hr/>
		
		<c:forEach var="i" begin="1" end="5">
			${i}<br/>
		</c:forEach>
		
		<c:forEach var="i" begin="1" end="10" step="2">
			${i}<br/>
		</c:forEach>
		
		<hr/>
		
		<%
		List<String> names = new ArrayList<String>();
		names.add("홍길동");
		names.add("서가람");
		names.add("안세은");
		request.setAttribute("names", names);
		%>
		
		<c:forEach var="i" items="${names}" varStatus="status">
			status.first: ${status.first},
			status.last: ${status.last},
			status.index: ${status.index},
			status.count: ${status.count}
			i: ${i} <br/>
		</c:forEach>
		
		<hr/>
		
		<c:forEach var="name" items="${names}" varStatus="status">
			<c:if test="${status.first}">
				<table>
					<tr>
						<th>이름</th>
					</tr>
			</c:if>
					<tr>
						<td>${name}</td>
					</tr>
			
			<c:if test="${status.last}">
				</table>
			</c:if>
		</c:forEach>
		
		
	</body>
</html>






