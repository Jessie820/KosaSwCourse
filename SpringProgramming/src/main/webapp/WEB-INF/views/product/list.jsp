<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			table{
				width:100%;
				border-collapse: collapse;
			
				font-size: small;
				
			}
			table, th, td{
				border: 1px solid black;
				text-align: center;
				background-color: white;
				
			}
			
			th{
				background-color: pink;
			}
			
			#buttonGroup{
				margin: 10px;
				text-align: center;
			}
			
		
			
			a{
			color: white;
			}
		</style>
	</head>
	
	<body>
		<h4>게시물 목록</h4>
		
		<table>
			<tr>
				<th style="width:50px">상품번호</th>
				<th style="width:60px">상품이름</th>
				<th style="width:80px">상품가격</th>
				<th style="width:60px">상품수량</th>
				<th style="width:60px">상품종류</th>
				<th style="width:60px">상품설명</th>
			</tr>
			
		<c:forEach var="product" items="${list}">
			<tr>
				<td>${product.no}</td>
				<td>${product.getName()}</a></td>
				<td>${product.getPrice()}</td>
				<td>${product.getAmount()}</td>
				<td>${product.getKind()}</td>
				<td>${product.getContent()}</td>
			</tr>
			
			</c:forEach>
		</table>
		<div id="buttonGroup">
		<a href="writeForm">글쓰기</a>
		</div>
	</body>
</html>







