<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>쿠키 삭제 하기</title>
</head>
<body>
<% 
	Cookie cookie = new Cookie("name", "");
	cookie.setMaxAge(0); //유효기간 0 : 강제로 지워버린다.
	response.addCookie(cookie);
%>
	<h2>쿠키가 삭제되었습니다.</h2>
	<a href="cookie2.jsp"> 쿠키 조회하기</a>
</body>
</html>