<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.net.*"%>

<%
String email = request.getParameter("email");
String name = "삼겹살";
name = URLEncoder.encode(name, "UTF-8");

/* <jsp:forward page="forwardForm.jsp"> 이게 있으면 forward에 있는 html 내용은 안 감! forwardForm에 있는 html만 실행! */
%>

<jsp:forward page="forwardForm.jsp"> 
	<jsp:param value="fall" name="id"/>
	<jsp:param value="<%=name%>" name="name"/>
</jsp:forward>



