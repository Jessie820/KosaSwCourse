<%@ page contentType="text/html; charset=UTF-8"%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
		body{
			font-family: "돋움";
			font-size: 12px;
			color: white;
			
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
			width: 90%;
			height: 100px;
			font-size: 12px;
		}
		
		#part1 {
			display: flex;
		}
		
		#part1_1{
			flex: 1;
		}
		
		#part1_2{
			width:120;
			margin-right: 10px;
			text-align: center;
		}
		
		#part1_2 img{
			display: block;
			padding: 10px;
		}
		
		
			#buttonGroup {
				margin: 10px;
				text-align: center;
			}
			
			#buttonGroup a {
				display:inline-block;
				width: 70px;
				line-height: 30px;
				text-decoration: none;
				font-size: small;
				color: white;
				border: 1px solid darkgray;
				background-color: gray;
				font-weight: bold;
			}
			
			#buttonGroup a:hover {
				color: black;
				background-color: lightgray;
			}
		
		</style>
	</head>
	
	<body>
		<h4>게시물 보기</h4>
		<div id="part1">
			<div id="part1_1">
				<span class="title">번호:</span>
				<span class="content">${product.no}</span><br/>
				
				<span class="title">이름:</span>
				<span class="content">${product.name}</span><br/>
				
				<span class="title">가격:</span>
				<span class="content">${product.price}</span><br/>
				
				<span class="title">수량:</span>
				<span class="content">${product.amount}</span><br/>
				
				<span class="title">종류:</span>
				<span class="content">${product.kind}</span><br/>
				
				<span class="title">내용:</span>
				<span class="content">${product.content}</span><br/>
				
				<span class="title">첨부:</span>
				<span class="content">${product.originalFileName}</span><br/>
				
			</div>
		
			<div id="part1_2">
				<%-- <img src="<%=request.getContextPath() %>/resources/uploadfiles/frontImage.jpg" width="100px" height="100px"/> --%>
				<img src="${pageContext.request.contextPath}/resources/uploadfiles/${product.filesystemName}" width="100px" height="100px"/>
				<button>다운로드</button>
			</div>
		
		</div>
		
		<div id="part2">
			<span class="title">내용:</span><br/>
			<pre>${product.content}</pre>
			
			<div id="buttonGroup">
				<a href="list">목록</a>
				<a href="updateForm?product_no=${product.no}">수정</a>
				<a href="delete?product_no=${product.no}">삭제</a>
			</div>
		</div>
	</body>
</html>








