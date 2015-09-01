<%@ page contentType="text/html; charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%-- 클라이언트가 보낸 데이터를 Product 객체에 저장 --%>
<jsp:useBean id="product" class="dto.Product">
	<jsp:setProperty name="product" property="*"/>
</jsp:useBean>

<!-- applicaiton 범위의 ProductService 객체 사용 -->
<jsp:useBean 
	id="productService" 
	class="service.ProductService"
	scope="application"/>

<%-- ProductService의 add() 메소드를 호출 --%>	
<%productService.add(product);%>

<% response.sendRedirect("list.jsp");%>