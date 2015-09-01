<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="dto.*" %>


<%
int productNo=Integer.parseInt(request.getParameter("product_no"));
%>

<jsp:useBean 
	id="productService" 
	class="service.ProductService"
	scope="application"/>
	
<%Product product = productService.getProduct(productNo); %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
		body{
			font-family: "돋움";
			font-size: 12px;
			
		}
		span{
			margin: 2px 10px;
			display: inline-block;
		}
		span.title{
			border: 1px solid darkgray;
			background: lightgray;
			width: 70px;
			text-align: center;
		}
		
		pre{
			margin: 10px;
			border: 1px solid darkgray;
			padding: 10px;
			width: 300px;
			height: 100px;
			font-size: 12px;
		}
		</style>
	</head>
	
	<body>
		<h4>게시물 보기</h4>
		<span class="title">상품번호:</span>
		<span class="content"><%=product.getNo()%></span><br/>
		
		<span class="title">상품이름:</span>
		<span class="content"><%=product.getName()%></span><br/>
		
		<span class="title">상품가격:</span>
		<span class="content"><%=product.getPrice()%></span><br/>
		
		<span class="title">상품수량:</span>
		<span class="content"><%=product.getAmount()%></span><br/>
		
		<span class="title">상품종류:</span>
		<span class="content"><%=product.getKind()%></span><br/>
		
		<span class="title">상품설명:</span><br/>
		<pre><%=product.getContent()%></pre>
		
		<div id="buttonGroup">
		<a href="list.jsp">
			<img src="../common/images/board/list.gif"/>
		</a>
		<a href="modify_form.jsp?product_no=<%=product.getNo()%>">
			<img src="../common/images/board/modify.gif"/>
		</a>
		<a href="delete.jsp?product_no=<%=product.getNo()%>">
			<img src="../common/images/board/delete.gif"/>
		</a>
		</div>
	</body>
</html>








