<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			*{
				color: white;
				margin: 0px;
				padding: 0px;
			}
		
			#a1 {
				width: 100px;
				height: 30px;
				background-color: #786633;
				margin: 5px;
				border-radius: 10px;
				box-shadow: 5px 5px 5px #352020;
			}
			
			#a1:hover{
				color: yellow;
				background-color: #A09470;
				
			}
			#a1:active{
				color: blue;
				background-color: #786633;
			}
			
			#a2 {
				width: 200px;
				height: 30px;
				background-color: #786633;
				margin: 5px;
				
				border-radius: 10px;
				box-shadow: 5px 5px 5px #352020;
			}
			
			#a2:hover{
				color: yellow;
				background-color: #A09470;
			}
			#a2:active{
				color: blue;
				background-color: #786633;
			}
			
			#category> a {
				display: block;
				text-align: center;
				line-height: 30px;
			}
			body {
				
				width: 800px;
				margin: 0 auto;/* auto: 중앙정렬 */
				background-color: #393914;
				
			}
			#page-wrapper {
				background-image: url('tree.jpg');
				background-color: #ffffff;
				margin:40px 0px;
				padding: 10px 20px;
				
				
			}
 			header {
				margin-bottom: 10px;
			}
			
			nav {
				border-top: 1px solid #c8c8c8;
				border-bottom: 1px solid #c8c8c8;
				display: flex;
				flex-direction: row;
			}
			.menu{
				margin: 5px;
				width: 50px;
			}
			#content {
				height: 500px;
				display: flex;
				flex-direction: row;
				color: white;
			}
			
			aside {
				border-right: 1px solid #c8c8c8;
				overflow:scroll;
				height: 500px;
				width: 250px;
			}
			section {
				color: color;
				height: 450px;
				flex: 1;
			}
			iframe {
				border: 0 solid white;
				background-color: white;
				overflow: scroll;
			}
		
			footer {
				height: 100px;
				border-top: 1px solid #c8c8c8;
			} 
		</style>
	</head>
	
	<body>
	
		<div id="page-wrapper">
			<header>
				<h1>JspProgramming</h1>
			</header>
			<nav>
				<div class="menu">Menu1</div>
				<div class="menu">Menu2</div>
				<div class="menu">Menu3</div>
				<div class="menu">Menu4</div>
				<div class="menu">Menu5</div>
			</nav>
			<div id="content" >
				<aside>
					<div id="category">
					
					<p class="chapter">[Ch04: 서블릿]</p>
					<a href="HelloWorldServlet1" target="iframe" id="a2">Servlet3.0방식으로 등록</a>
					<a href="HelloWorldServlet2" target="iframe" id="a2">이전 방식으로 등록</a>
					<a href="HelloWorldServlet3" target="iframe" id="a2">load on startup</a>
					<a href="HelloWorldServlet4" target="iframe" id="a2">외부 정보 받기</a>
					<a href="ch04/service_get_post.jsp" target="iframe" id="a2">요청 방식별 처리</a>
					<a href="LoginServlet" target="iframe" id="a2">요청 처리 및 응답 보내기</a>
					
					
						<p class="chapter">[Ch05: JSP 기초 문법]</p>
						<a href="ch05/dec_express/comment.jsp" target="iframe" id="a1">주석</a>
						<a href="ch05/directives/index.jsp" target="iframe" id="a1">지시어</a>
						<a href="ch05/action/index.jsp" target="iframe" id="a1">표준액션</a>
						<a href="ch05/dec_express/scriptlet1.jsp" target="iframe" id="a1">스크립트릿1</a>
						<a href="ch05/dec_express/scriptlet2.jsp" target="iframe" id="a1">스크립트릿2</a>
						<a href="ch05/dec_express/calco3.jsp" target="iframe" id="a1">선언문</a>
					<br/>
						<p class="chapter">[Ch06: JSP 내장 객체]</p>
						<a href="ch06/builtin_object.jsp" target="iframe" id="a2">JSP 내장 객체 개요</a>
						<a href="ch06/request/index.jsp" target="iframe" id="a2">request</a>
						<a href="ch06/response/index.jsp" target="iframe" id="a2">response</a>
						<a href="ch06/cookie/index.jsp" target="iframe" id="a2">cookie</a>
						<a href="ch06/session/index.jsp" target="iframe" id="a2">session</a>
						<a href="ch06/application/index.jsp" target="iframe" id="a2">application</a>
					
					<p class="chapter">[Ch07: JSP 자바 빈즈]</p>
					<a href="ch07/dto.jsp" target="iframe" id="a2">DTO 이용 방법</a>
					<a href="ch07/dto_auto_setting.jsp" target="iframe" id="a2">DTO값 저장</a>
					<a href="ch07/bean_scope.jsp" target="iframe" id="a2">빈의 사용 범위</a>
					<a href="ch07/dao.jsp" target="iframe" id="a2">DAO 이용 방법</a>
					<a href="ch07/service.jsp" target="iframe" id="a2">Service 이용 방법</a>
					<a href="ch07/database_form.jsp" target="iframe" id="a2">데이터베이스 연동</a>
					
					<p class="chapter">[Ch10: 표현 언어]</p>
					
					<p class="chapter">[Ch11: JSTL]</p>
					<a href="ch11/forEach.jsp" target="iframe" id="a2">&lt;c:forEach&gt;</a>
					
					<br/>
					<p class="chapter">[실습01: 게시판]</p>
						<a href="exam01/list.jsp" target="iframe" id="a2">게시판 목록</a>
					
					<br/>
					<p class="chapter">[실습02: 상품 게시판]</p>
						<a href="exam02/list.jsp" target="iframe" id="a2">게시판 목록</a>
						
					<br/>
					<p class="chapter">[실습03: MVC 게시판]</p>
						<a href="mvc/board?action=list" target="iframe" id="a2">게시판 목록</a>
					
					<br/>
						<p class="chapter">[기본실습]</p>
						<a href="ch06/login/login.jsp" target="iframe" id="a2">로그인</a>
			>
					<br/>
						<p class="chapter">[응용실습]</p>
						<a href="ch06/twitter/twitter_login.jsp" target="iframe" id="a2">트위터 로그인</a>
						
						
						
					</div>
						
				</aside>
				<section>
					<iframe name="iframe" width="100%" height="100%">
					
					</iframe>
				</section>
			</div> 
			<footer>
			ljy
			</footer>
		</div>
	</body>
</html>