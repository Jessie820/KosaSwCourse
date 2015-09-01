<%@ page contentType="text/html; charset=UTF-8"%>
<%	
	request.setCharacterEncoding("UTF-8");
	String title = request.getParameter("title");
	String username = request.getParameter("username");
	String content = request.getParameter("content");
	String sex = request.getParameter("sex"); 
	String password = request.getParameter("password");
	String open = request.getParameter("open");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	
	<body>
		title: <%=title %></br>
		username: <%=username %></br>
		content:  <%=content%></br>
		sex:  <%=sex%></br>
		password:  <%=password%></br>
		open:  <%=open%></br>
	</body>
</html>