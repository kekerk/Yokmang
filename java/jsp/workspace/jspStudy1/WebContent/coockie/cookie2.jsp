<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>쿠키 정보 조회하기</title>
</head>
<body>
<%
	//request.getCookies() : 브라우저가 저장된 쿠키를 서버에 보냄. 쿠키목록 리턴.
	Cookie[] cookies = request.getCookies();
	String name = null;
	String value = null;
	for(Cookie c : cookies){
		if(c.getName().equals("name")){
			name = c.getName();
			value = c.getValue();
		}
	}
%>
<h2>쿠키이름 : <%=name %></h2>
<h2>쿠키값 : <%=value %></h2>
<%-- 모든 쿠키의 이름과 값을 출력하기 : 김동진 --%>
<%--  --%>
<hr>
<h2>모든 쿠키의 이름과 값 출력</h2>
<%  for(Cookie c : cookies) { %>
<h2>Cookie c: <%=c %></h2><br>
<h2>쿠키이름 : <%=c.getName() %></h2><br>
<h2>쿠키값 : <%=c.getValue() %></h2><br> 
<br>
<%} %>
<%-- --------------------------------------- --%>
<br>
<a href="cookie3.jsp">쿠키 삭제하기</a>
</body>
</html>