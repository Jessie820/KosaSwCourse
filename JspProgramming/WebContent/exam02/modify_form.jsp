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
		
		<script type="text/javascript">
			function sendData(){
				 //값의 유효성 검사
	            //var modifyForm=document.querySelector("#modifyForm");
	            var modifyForm =document.modifyForm;
	            console.log(modifyForm);
	           
	            var name=document.modifyForm.name.value;
	            var price=document.modifyForm.price.value;
	            var amount=document.modifyForm.amount.value;
	            var content=document.modifyForm.content.value;
	          
	            if(name == "" || price =="" || amount =="" || content ==""){
	            	alert("공란이 있으면 안 됩니다~");
	            	return;
	            }
	            //서버로 전송
	            modifyForm.submit();
				
			}
		</script>
	</head>
	
	<body>
		<h4>게시물 보기</h4>
		<form id="modifyForm" name="modifyForm" method="post" action="modify.jsp">
			<span class="title">번호:</span>
			<span class="content"><%=product.getNo()%></span><br/>
			<input type="hidden" name="no" value="<%=product.getNo()%>"><br/>
			
			<span class="title">상품이름:</span>
			<input type="text" name="name" value="<%=product.getName()%>"/><br/>
			
			<span class="title">상품가격:</span>
			<input type="text" name="price" value="<%=product.getPrice()%>"/><br/>
			
			<span class="title">상품수량:</span>
			<input type="text" name="amount" value="<%=product.getAmount()%>"/><br/>
			
			<span class="title">상품종류:</span>
			<span class="content"><%=product.getKind()%></span><br/>
			
			<span class="title">상품설명:</span><br/>
			<textarea id="content" name="content" rows="5" cols="50" ><%=product.getContent()%></textarea>
		</form>
		
		<div id="buttonGroup">
		<a href="javascript:sendData()">[수정]</a>
		<a href="delete.jsp?product_no=<%=product.getNo()%>">[취소]</a>
		</div>
	</body>
</html>








