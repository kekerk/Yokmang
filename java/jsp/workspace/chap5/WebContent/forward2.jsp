<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>forward action tag exercise</title>
</head>
<body>
<h2>forward2.jsp 페이지 : forward1.jsp 페이지에서 forward된 페이지 입니다.</h2>
<h3>요청 파라미터 정보</h3>
Name : <%=request.getParameter("name") %><br>
Id : <%=request.getParameter("id") %><br>
Tel : <%=request.getParameter("tel") %><br>
Test : <%=request.getParameter("test") %>

</body>
</html>