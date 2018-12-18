<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>오류 발생 페이지 2</title>
</head>
<body>
<%=Integer.parseInt("abc") %>
</body>
</html>
<%--
	에러페이지 처리 우선 순위
	1. 해당페이지에서 <%@ page errorPage="____" %> 설정
	2. web.xml에 설정된 예외 객체별 처리
	3. web.xml에 설정된 예외 코드별 처리
	4.톰캣(웹 어플리케이션 서버, 웹 컨테이너)에서 제공하는 기본 에러 페이지
--%>