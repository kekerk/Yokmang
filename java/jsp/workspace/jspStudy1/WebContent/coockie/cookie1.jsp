<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>쿠키 생성하기</title>
</head>
<body>
<% Cookie cookie = new Cookie("name","hongkildong");
		cookie.setMaxAge(10*60); //유효 시간을 설정함. 600초
		response.addCookie(cookie); // 쿠키를 응답객체에 저장해줌. 브라우저로 쿠키를 전송한다는 의미.
%>
<h2>쿠키이름:<%=cookie.getName() %></h2> 
<h2>쿠키값:<%=cookie.getValue() %></h2>
<h2>쿠키유효시간:<%=cookie.getMaxAge() %></h2>
<a href="cookie2.jsp">쿠키값 불러오기</a>
</body>
</html>