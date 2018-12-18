<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% request.setCharacterEncoding("EUC-KR"); %>
<h2>info.jsp 페이지입니다. </h2>
<%
	String city = request.getParameter("loc")+".jsp";
%>
<jsp:forward page="<%=city %>"></jsp:forward>
</body>
</html>