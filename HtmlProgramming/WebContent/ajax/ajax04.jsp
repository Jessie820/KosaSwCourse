<%@ page contentType="text/html; charset=UTF-8"%>

<%String method = request.getMethod();%>

<%if(method.equals("GET")) {%>
<h4>Get방식 요청 결과</h4>
<img src="../common/images/avata/0219m2_09[1].gif"/>

<%} else if(method.equals("POST")){%>
<h4>POST 방식 요청 결과</h4>
<img src="../common/images/avata/0219m2_09[1].gif"/>
<%}%>