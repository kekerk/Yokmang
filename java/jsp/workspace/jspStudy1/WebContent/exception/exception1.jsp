<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<%-- 
		error 페이지 지정하기
	<%@ page errorPage="error.jsp" %> : 에러가 발생하면 error.jsp 페이지를 출력.		
 --%>
<%-- <%@ page errorPage="error.jsp" %>  : error.jsp가 error500.jsp보다 우선순위가 높다.--%> 
<html>
<head>
<meta charset="EUC-KR">
<title>오류 발생 페이지</title>
</head>
<body>
<%=request.getParameter("name").trim() %>
</body>
</html>