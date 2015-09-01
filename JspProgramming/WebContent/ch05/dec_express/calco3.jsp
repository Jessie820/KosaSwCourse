<%@ page contentType="text/html; charset=UTF-8"%>
<%!
	//필드
	int num1, num2;
	int result;
	String op = "";//null 과 빈문자열은 다른 얘기
	
	//메소드
	public int calculator(){
		if(op.equals("+")){
			result = num1 + num2;
		}else if(op.equals("-")){
			result = num1 - num2;
		}else if(op.equals("*")){
			result = num1 * num2;
		}else if(op.equals("/")){
			result = num1 / num2;
		}
	return result;
	}	
%>
<% 

	// 웹 페이지 요청이 POST인 경우에만 수행, 즉 폼을 통해 전달된 것만 수행
	//초기 로딩시 오류 방지
	//스트립트릿: 요청시마다 실행되는 코드
	System.out.println("스크립트릿1");
	if(request.getMethod().equals("POST")){
		
		//문자열 형태로 전달된 인자들을 int로 변환함
		num1 = Integer.parseInt(request.getParameter("num1"));
		num2 = Integer.parseInt(request.getParameter("num2"));
		op = request.getParameter("operator");
	}
%>

<%
System.out.println("스크립트릿2");
%>

<html>
	<head>
		<metacharset="UTF-8">
		<title><%="계산기" %></title>
		<% 
		String title = "계산기";
		%>
		<title><%=title %></title>
		
		<% 
		int e = 0;
		%>
		<title><%=e %></title>
		<%-- <title><%=int x=0; %></title> 
		<title><%=String s = "계산기" %></title>
		값이 아니라 실행문이라 안 됨--%>
	</head>
	
	<body>
		<center>
		<h3>계산기</h3>
		<hr>
		<form name=form1 method=post>
		<input type="text" name="num1" width=200 size="5">
		<select name="operator">
			<option selected>+</option>
			<option>-</option>
			<option>*</option>
			<option>/</option>
		</select>
		<input type="text" name="num2" width=200 size="5">
		<input type="submit" value="계산" name="B2">
		</form>
		<hr>
		<!-- 표현식:하나의 값을 출력하는 코드 -->
		계산 결과: <%=calculator() %>
	</body>
</html>