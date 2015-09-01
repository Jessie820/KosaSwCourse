
<%response.sendRedirect("page_control_end.jsp");%>


<% 
String username=request.getParameter("username");
String tel=request.getParameter("tel");
response.sendRedirect(
		"page_control_end?username=" + username + "&" + 
		"tel=" + tel
		
		);
		%>