<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*" %>

<%
response.setDateHeader("Expires", 0);
/* Expires, 이 다음에 현재 날짜보다 적은 날짜 넣으면 이전에 캐싱했던 것이 지워짐 */
response.setHeader("CaChe-Control", "no-cache");
/* 캐싱 하지 말라고 지시 */
/* 캐싱 안 하는 이유는 서버에서 바뀐 내용을 반영 못 할 수 있기 때문*/
/* 요즘엔 브라우저가 똑똑해져서 이 코드 넣을 필요 없음 */

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		no_cache.jsp
		<hr/>
	</body>
</html>