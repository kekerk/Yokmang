<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>방문자 기록창</title>
</head>
<body>
<%request.setCharacterEncoding("EUC-KR"); %> <!--  언어부터 인코딩 --> 
<% 
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		String s = sf.format(new Date());
%>
<table border="1">
<caption>방명록</caption>
<tr><td>방문자</td><td><%=request.getParameter("writer") %></td></tr>
<tr><td>제목</td><td><%=request.getParameter("title") %></td></tr>
<tr><td>내용</td><td><%=request.getParameter("content") %></td></tr>
<tr><td>등록일</td><td><%=s %></td></tr>
</table>
</body>
</html>
<%-- jsp 내장 객체 (8+1)
		request
		application
		response
		session
		pageContext
		out, page, ...
	
--%>