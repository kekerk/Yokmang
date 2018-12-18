<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<!--  /WebContent/response1.jsp : 응답객체 예제 -->
<html>
<head>
<meta charset="EUC-KR">
<title>응답 객체 : sendRedirect 예제</title>
</head>
<body>
<h2>response 객체는 응답 객체로 서버에서 브라우저로 정보를 전달하는 기능을 가진 객체입니다. <br>
이 내용은 <mark>response1.jsp</mark>페이지에서 작성된 내용이지만 화면에 출력되지는 않습니다.</h2>
<%response.sendRedirect("response2.jsp"); %>
</body>
</html>