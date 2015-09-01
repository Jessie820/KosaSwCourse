<%@ page contentType="text/html; charset=UTF-8"%>
<%-- <%@page import="com.mysql.jdbc.Connection%>--%>
<%--java.sql.DriverManager"%>--%>

<%-- <%@page import="com.mysql.jdbc.Connection, java.sql.DriverManager"%> --%>
<!-- 위에 처럼 써도 됨-->
<%@page import="java.sql.Connection, java.sql.DriverManager" %>
<%@page import="java.sql.*, java.util.*"%>

<!--기본적으로 import되는 패키지
	1) javax.servlet
	2) javax.servlet.http
	3) javax.servlet.jsp
  -->

<%
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection(
		"jdbc:mysql://blueskii.iptime.org:3306/team3", "team3", "123456"
		);

Calendar now= Calendar.getInstance();
int year = now.get(Calendar.YEAR);
int month = now.get(Calendar.MONTH)+1;
int day = now.get(Calendar.DAY_OF_MONTH);
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		연결 성공 <br/>
		오늘 날짜: <%=year %>.<%=month %>.<%=day %>
	</body>
</html>