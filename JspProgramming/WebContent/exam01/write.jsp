<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import= "dto.*, com.oreilly.servlet.*, com.oreilly.servlet.multipart.*"%>


<%
DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
String urlPath = "/uploadfiles";
String saveFilePath = application.getRealPath(urlPath);

System.out.println(saveFilePath);
MultipartRequest mr = 
	new MultipartRequest(request, saveFilePath, 1024*1024*5, "UTF-8", policy);
/*  Policy: 중복된 파일명이 있으면 어떻게 할거냐라는 거 정해줌. 
cos.jar의 DefaultFileRenamePolicy을 따르게 됨

*/

Board board = new Board();
board.setTitle(mr.getParameter("title"));
board.setWriter(mr.getParameter("writer"));
board.setContent(mr.getParameter("content"));
board.setOriginalFileName(mr.getOriginalFileName("attach"));
board.setFilesystemName(mr.getFilesystemName("attach"));
board.setContentType(mr.getContentType("attach"));
%>
<!-- applicaiton 범위의 BoardService 객체 사용 -->
<jsp:useBean 
	id="boardService" 
	class="service.BoardService"
	scope="application"/>

<%-- BoardService의 add() 메소드를 호출 --%>	
<%boardService.add(board);%>

<%-- BoardService의 add() 메소드를 호출 --%>	
<%response.sendRedirect("list.jsp");%>


String title = mr.getParameter("title");
System.out.println(title);
String writer = mr.getParameter("writer");
System.out.println(writer);
String content = mr.getParameter("content");
System.out.println(content);

String ofn = mr.getOriginalFileName("attach");
String fyn = mr.getFilesystemName("attach");
System.out.println(ofn);
System.out.println(fyn);


String contentType = mr.getContentType("attach");
System.out.println(contentType);
/* 오리지날 파일이름과 파일시스템 이름을 둘 다 DB에 저장해야 한다. 
나중에 다운받을 때 오리지널 이름으로 다운받는다.*/
%>

